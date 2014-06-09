package shopwatcher.taobao

import shopwatcher.DailyCountService

class DailySalesController {

    DailyCountService dailyCountService

    def index() {}

    def todaySales() {
        def toCrawlerUrl = "http://nv-er.taobao.com/search.htm?v=1&orderType=hotsell_desc"
    }

    def test() {
        dailyCountService.findProductTodaySalesInfo("")
    }
}
