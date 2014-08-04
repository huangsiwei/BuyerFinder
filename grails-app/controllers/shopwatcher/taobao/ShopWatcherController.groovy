package shopwatcher.taobao

import shopwatcher.WatcherService

class ShopWatcherController {

    WatcherService watcherService

    def index() {}

    def miniTest() {
        def shopHotSellerDescUrl = "http://nv-er.taobao.com/search.htm?search=y&orderType=hotsell_desc&v=1"
        watcherService.findShopProducts(shopHotSellerDescUrl)
    }

    def compareHotSell() {
        def shopNameList = ["女尔","未闻"]


        println("break!")

    }
}
