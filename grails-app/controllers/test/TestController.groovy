package test

import base.CrawlerService
import common.CommonService
import shopwatcher.WatcherService

class TestController {

    CrawlerService crawlerService
    WatcherService watcherService
    CommonService commonService

    def index() {}

    def testCrawler() {
        def startTimeStr = "2014-07-25"
        def startTime = commonService.setDateAndTime(startTimeStr, 0, 0, 0)
        crawlerService.crawlShopSalesInfo([], startTime)
    }

    def testCompareHotSell() {
        watcherService.compareShopHotSell(["女尔", "未闻"])
    }
}
