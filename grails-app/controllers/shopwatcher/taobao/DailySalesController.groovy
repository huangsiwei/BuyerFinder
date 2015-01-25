package shopwatcher.taobao

import common.CommonService
import grails.converters.JSON
import shopwatcher.DailyCountService
import shopwatcher.WatcherService

class DailySalesController {

    DailyCountService dailyCountService
    CommonService commonService
    WatcherService watcherService

    def index() {

    }

    def todaySales() {
        def toCrawlerUrl = "http://nv-er.taobao.com/search.htm?v=1&orderType=hotsell_desc"
    }

    def test() {
        def startDate = commonService.setDateAndTime("2014-10-1", 9, 0, 0)
        def hotSellUrl = "http://nv-er.taobao.com/search.htm?spm=a1z10.1.0.0.sJSomD&search=y&orderType=hotsell_desc&v=1"
        def productList = watcherService.findShopProducts(hotSellUrl)
        println(productList)
        productList.each { productUrl ->
            def productName = dailyCountService.findProductName(productUrl)
            def salesInfoList = []
            List resultList = dailyCountService.findProductTodaySalesInfo(productUrl, 1, salesInfoList, startDate, productName, "nothing")
            if (resultList.size() > 0) {
                println("======================================")
                println(productName)
                println(">>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<")
                resultList.each { salesInfo ->
                    println(salesInfo["buyer"] + "||" + salesInfo["price"] + "||" + salesInfo["salesAmount"] + "||" + salesInfo["skuWarp"] + "||" + salesInfo["salesDate"])
                }
            }
        }
        println("end!!!")
    }

    def salesStatistics() {

    }

    def fetchSalesInfo() {
        String startDate = params.startDate
        String startHourAndMin = params.startHourAndMin
        int startHour = startHourAndMin.split(":")[0] as int
        int startMin = startHourAndMin.split(":")[1] as int
        def startTime = commonService.setDateAndTime(startDate, startHour, startMin, 0)
        return startTime as JSON
    }
}
