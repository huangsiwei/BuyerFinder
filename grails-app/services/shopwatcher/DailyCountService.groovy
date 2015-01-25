package shopwatcher

import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.protocol.HTTP
import org.json.simple.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import salesinfo.SaleInfo

class DailyCountService {

    static basicUrl = "http://detailskip.taobao.com/json/show_buyer_list.htm?"

    def findProductName(String productUrl) {
        Document document = Jsoup.connect(productUrl).get()
        def productName = document.select(".tb-main-title").html()
        return productName
    }

    def findProductTodaySalesInfo(String productUrl, int pageNum, List salesInfoList, Date startDate, String productName, String processingMethod) {
        Document document = Jsoup.connect(productUrl).timeout(10000).get()
        def item_id = document.select("#J_Pine").attr("data-itemid")
        def seller_num_id = document.select("#J_Pine").attr("data-sellerid")
//        println(document.select("#J_listBuyerOnView").attr("data-api"))
//        println(productUrl)
        def sbn = document.select("#J_listBuyerOnView").attr('data-api').split("sbn=")[1].split("&")[0]
        def shopName = document.select(".tb-shop-name dd").text()
        String salesInfoURL = basicUrl + "&bid_page=" + pageNum + "&page_size=15" + "&item_id=" + item_id + "&seller_num_id=" + seller_num_id + "&sbn=" + sbn + "&callback=Hub.data.records_reload&qq-pf-to=pcqq.c2c"
        def nextPageFlag = true
        String result = new URL(salesInfoURL).getText('GBK', connectTimeout: 10000).replace('Hub.data.records_reload({html:"', '').replace(' ",type:"list"})', "").replaceAll(/\\(['"])/, '$1')
        Document resultDoc = Jsoup.parse(result)
        def buyerList = resultDoc.select("tr [class=tb-sellnick]")
        if (buyerList.size() == 0) {
            nextPageFlag = false
        } else {
            buyerList.each { buyer ->
                def salesRef = buyer.parent().parent()
                def buyerName = buyer.html().replace('<span class="tb-anonymous">**</span>', '**')
                def price = salesRef.select("td [class=tb-rmb-num]").html()
                def priceFloat = price as float
                def salesAmount = salesRef.select(".tb-amount").html() as int
                def skuWarp = salesRef.select('.tb-sku p')[0].html()
                def salesDateStr = salesRef.select(".tb-start").html()
                def salesInfo = ["buyer": buyerName, "price": price, "salesAmount": salesAmount, "skuWarp": skuWarp, "salesDate": salesDateStr]
                Date salesDate = Date.parse("yyyy-MM-dd HH:mm:ss", salesDateStr)   //2011-08-20T02:06:57.931Z
                if (salesDate > startDate) {
                    if (processingMethod == "AVOS") {
                        JSONObject jsonObj = new JSONObject();
                        jsonObj.put("buyer", buyerName);
                        jsonObj.put("price", priceFloat);
                        jsonObj.put("salesAmount", salesAmount);
                        jsonObj.put("skuWarp", skuWarp);
                        jsonObj.put("productName", productName)
                        JSONObject dateJObj = new JSONObject();
                        dateJObj.put("__type", "Date")
                        String dateStr = salesDate.format("yyyy'-'MM'-'dd'T'hh':'mm':'ss'.'000'Z'")
                        dateJObj.put("iso", dateStr);        //2014-07-03T22:16:025Z
                        jsonObj.put("salesDate", dateJObj);
                        HttpPost httpPost = new HttpPost("https://cn.avoscloud.com:443/1/classes/BasicSalesInfo");
                        StringEntity entity = new StringEntity(jsonObj.toString(), HTTP.UTF_8);
                        entity.setContentType("application/json");
                        httpPost.setEntity(entity);
                        httpPost.setHeader("X-AVOSCloud-Application-Id", "kwl4u1n7cegjj5darpgu5ujgcnd725kxm6gjgsd4uvlbvu59")
                        httpPost.setHeader("X-AVOSCloud-Application-Key", "c82sov0nxfdw65udcwaxkwa0zgx7taet3enpsalid748vupe")
                        HttpClient client = new DefaultHttpClient();
                        HttpResponse response = client.execute(httpPost);
                    }
                    if (processingMethod == "MySQL") {
                        SaleInfo saleInfo = new SaleInfo()
                        saleInfo.buyerName = buyerName
                        saleInfo.price = priceFloat
                        saleInfo.salesAmount = salesAmount
                        saleInfo.skuWarp = skuWarp
                        saleInfo.salesDate = salesDate
                        saleInfo.shopName = shopName
                        saleInfo.productName = productName
                        saleInfo.save()
                    }

                    salesInfoList << salesInfo

                } else {
                    nextPageFlag = false
                }
            }
        }
        if (!nextPageFlag) {
            return salesInfoList
        } else if (nextPageFlag) {
            findProductTodaySalesInfo(productUrl, pageNum + 1, salesInfoList, startDate, productName, processingMethod)
        }
    }
}
