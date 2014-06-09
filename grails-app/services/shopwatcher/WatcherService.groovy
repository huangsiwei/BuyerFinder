package shopwatcher

import org.jsoup.Jsoup
import org.jsoup.nodes.Document


class WatcherService {

    def findShopProducts(String shopHotSellerDescUrl){
//        pageNum=1
        Document document = Jsoup.connect(shopHotSellerDescUrl).get()
        def productNum = document.select(".search-result span").html() as Integer
        def pageNum = Math.ceil(productNum/24) as Integer
        def productListUrlList = []
        (1..pageNum).each {
            String productPageUrl = shopHotSellerDescUrl + "&pageNum=" + it as String
            productListUrlList << productPageUrl
        }
        Set productList = []
        productListUrlList.each {String productPage ->
            sleep(3000)
            println(productPage)
            println("=====================")
            Document productPageDoc = Jsoup.connect(productPage).get()
            def productBlockList = productPageDoc.select(".item")
            productBlockList.each { productBlock ->
                def productURL = productBlock.select("a").attr("href").replace("&","")
                println(productURL)
                productList << productURL
            }
            println("=====================")
            println(productList.size())
            println("=====================")
        }
        return productList
    }

}
