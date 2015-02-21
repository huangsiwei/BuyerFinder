package base

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import shopwatcher.DailyCountService
import shopwatcher.WatcherService

class CrawlerService {

    WatcherService watcherService
    DailyCountService dailyCountService

    def basicPageCrawler(String pageUrl,String selector,List<String> selectorList) {
        def resultList = []
        Document document = Jsoup.connect(pageUrl).timeout(10000).get()
        def itemList = document.select(selector)
        for (int i = 0; i < itemList.size(); i++) {
            def resultMap = [:]
            for (int j = 0; j < selectorList.size(); j++) {
                resultMap[selectorList[j]] = itemList.select(selectorList[j])[i].text()
            }
            resultList << resultMap
        }
        return resultList
    }

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
