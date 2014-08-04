package base

import shopwatcher.DailyCountService
import shopwatcher.WatcherService

class CrawlerService {

    WatcherService watcherService
    DailyCountService dailyCountService

    def crawlShopSalesInfo(List shopList, Date startTime) {
        shopList = ["http://nv-er.taobao.com/", "http://weiwen-love.taobao.com/"]
        def basicHotSell = "search.htm?orderType=hotsell_desc&v=1"
        def shopHotSellList = shopList.collect {
            it + basicHotSell
        }

        shopHotSellList.each { shopHotSellUrl ->
            def hotSellProductList = watcherService.findShopProducts(shopHotSellUrl)
            hotSellProductList.each { productUrl ->
                def productName = dailyCountService.findProductName(productUrl)
                def salesInfoList = []
                dailyCountService.findProductTodaySalesInfo(productUrl, 1, salesInfoList, startTime, productName)
            }
            println("break!")
        }
    }

}
