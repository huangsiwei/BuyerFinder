package shopwatcher

import common.CommonService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class DailyCountService {

    WatcherService watcherService
    CommonService commonService

//    static basicUrl = "detailskip.taobao.com/json/show_buyer_list.htm?bid_page=!&page_size=!!!&item_id=!!!&seller_num_id=!!!&sbn=!!!&callback=Hub.data.records_reload&qq-pf-to=pcqq.c2c"
    static basicUrl = "http://detailskip.taobao.com/json/show_buyer_list.htm?"

    def countSales(String toCrawlerUrl) {
        def productList = watcherService.findShopProducts(toCrawlerUrl)
    }

    def findProductName (String productUrl) {
        Document document = Jsoup.connect(productUrl).get()
        def productName = document.select(".tb-main-title").html()
        return productName
    }

    def findProductTodaySalesInfo(String productUrl,int pageNum,List salesInfoList,Date startDate) {
//        commonService.sleepRandomTime(4000,6000)
        Document document = Jsoup.connect(productUrl).timeout(10000).get()
        def item_id = document.select("#J_Pine").attr("data-itemid")
        def seller_num_id = document.select("#J_Pine").attr("data-sellerid")
        def sbn = document.select("#J_listBuyerOnView").attr("data-api").split("sbn=")[1].split("&")[0]
        String salesInfoURL = basicUrl + "&bid_page=" + pageNum + "&page_size=15" + "&item_id=" + item_id + "&seller_num_id=" + seller_num_id + "&sbn=" + sbn + "&callback=Hub.data.records_reload&qq-pf-to=pcqq.c2c"
        def nextPageFlag = true
//        commonService.sleepRandomTime(4000,6000)
        String result = new URL(salesInfoURL).getText('GBK',connectTimeout:10000).replace('Hub.data.records_reload({html:"', '').replace(' ",type:"list"})', "").replaceAll(/\\(['"])/, '$1')
        Document resultDoc = Jsoup.parse(result)
        def buyerList = resultDoc.select("tr [class=tb-sellnick]")
        if (buyerList.size() == 0){
            nextPageFlag = false
        } else {
            buyerList.each { buyer ->
                def salesRef = buyer.parent().parent()
                def buyerName = buyer.html().replace('<span class="tb-anonymous">**</span>', '**')
                def price = salesRef.select("td [class=tb-rmb-num]").html()
                def priceInt = price as float
                def salesAmount = salesRef.select(".tb-amount").html()
                def skuWarp = salesRef.select('.tb-sku p')[0].html()
                def salesDateStr = salesRef.select(".tb-start").html()
                def salesInfo = ["buyer": buyerName, "price": price, "salesAmount": salesAmount, "skuWarp": skuWarp, "salesDate": salesDateStr]
                Date salesDate = Date.parse("yyyy-MM-dd HH:mm:ss", salesDateStr)
                if (salesDate > startDate) {
                    salesInfoList << salesInfo
                } else {
                    nextPageFlag = false
                }
            }
        }
        if (!nextPageFlag) {
            return salesInfoList
        }else if (nextPageFlag) {
            findProductTodaySalesInfo(productUrl, pageNum + 1,salesInfoList,startDate)
        }
    }
}
