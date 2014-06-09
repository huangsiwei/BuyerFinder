package shopwatcher

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class DailyCountService {

    WatcherService watcherService

//    static basicUrl = "detailskip.taobao.com/json/show_buyer_list.htm?bid_page=!&page_size=!!!&item_id=!!!&seller_num_id=!!!&sbn=!!!&callback=Hub.data.records_reload&qq-pf-to=pcqq.c2c"
    static basicUrl = "http://detailskip.taobao.com/json/show_buyer_list.htm?"

    def countSales(String toCrawlerUrl) {
        def productList = watcherService.findShopProducts(toCrawlerUrl)
    }

    def findProductTodaySalesInfo(String productUrl) {
        def tmpProductUrl = "http://item.taobao.com/item.htm?id=38251117906"
        Document document = Jsoup.connect(tmpProductUrl).get()
        def item_id = document.select("#J_Pine").attr("data-itemid")
        def seller_num_id = document.select("#J_Pine").attr("data-sellerid")
        def sbn = document.select("#J_listBuyerOnView").attr("data-api").split("sbn=")[1].split("&")[0]
        String salesInfoURL = basicUrl + "&bid_page=1" + "&page_size=15" + "&item_id=" + item_id + "&seller_num_id=" + seller_num_id + "&sbn=" + sbn + "&callback=Hub.data.records_reload&qq-pf-to=pcqq.c2c"
        String result = new URL(salesInfoURL).getText('GBK').replace('Hub.data.records_reload({html:"', '').replace(' ",type:"list"})', "").replaceAll(/\\(['"])/, '$1')
        Document resultDoc = Jsoup.parse(result)
        def buyerList = resultDoc.select("tr [class=tb-sellnick]")

        def salesInfoList = []

        buyerList.each { buyer ->
            def salesRef = buyer.parent().parent()
            def buyerName = buyer.html().replace('<span class="tb-anonymous">**</span>', '**')
            def price = salesRef.select("td [class=tb-rmb-num]").html()
            def salesAmount = salesRef.select(".tb-amount").html()
            def skuWarp = salesRef.select('.tb-sku p')[0].html()
            def salesDateStr = salesRef.select(".tb-start").html()
            def salesInfo = ["buyer": buyerName, "price": price, "salesAmount": salesAmount, "skuWarp": skuWarp, "salesDate": salesDateStr]
            Date salesDate = Date.parse("yyyy-MM-dd HH:mm:ss", salesDateStr)
            println(salesDate)
            if (salesDate < (new Date()-1)) {


            }
            salesInfoList << salesInfo
        }

        return salesInfoList
    }
}
