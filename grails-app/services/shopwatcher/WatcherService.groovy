package shopwatcher

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import salesinfo.SaleInfo


class WatcherService {

    def findShopProducts(String shopHotSellerDescUrl) {
        Document document = Jsoup.connect(shopHotSellerDescUrl).get()
        def productNum = document.select(".search-result span").html() as Integer
        def pageNum = Math.ceil(productNum / 24) as Integer
        def productListUrlList = []
        (1..pageNum).each {
            String productPageUrl = shopHotSellerDescUrl + "&pageNum=" + it as String
            productListUrlList << productPageUrl
        }
        Set productList = []
        productListUrlList.each { String productPage ->
            Document productPageDoc = Jsoup.connect(productPage).get()
            def productBlockList = productPageDoc.select(".item")
            productBlockList.each { productBlock ->
                def productURL = productBlock.select("a").attr("href").replace("&", "")
                productList << productURL
            }
        }
        return productList
    }

    def compareShopHotSell(List shopList) {
        shopList.each { shop ->
//            SaleInfo.findAllByShopName(shop, sort: "title", order: "desc")
            def c = SaleInfo.createCriteria()
            def result = c {
                projections {
                    groupProperty("productName")
                    sum ("salesAmount","salesCount")
                }
                order "salesCount"
            }
            println("break!")
        }
    }

}
