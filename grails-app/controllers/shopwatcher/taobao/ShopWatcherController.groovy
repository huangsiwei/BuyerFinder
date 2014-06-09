package shopwatcher.taobao

import shopwatcher.WatcherService

class ShopWatcherController {

    WatcherService watcherService

    def index() {}

    def miniTest() {
        def shopHotSellerDescUrl = "http://520smida.taobao.com/search.htm?v=1&scene=taobao_shop&orderType=hotsell_desc"
        watcherService.findShopProducts(shopHotSellerDescUrl)
    }
}
