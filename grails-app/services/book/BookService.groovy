package book

import common.CommonService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class BookService {

    CommonService commonService

    def getFavReader (String bookId,int startPage,int endPage) {
        String defBookURL = "http://book.douban.com/subject/" + bookId + "/collections?start="
        List collectionsURLList = []
        def favReaderDouMailList = []
        String selector = "#collections_tab .sub_ins tr"
        (0..(endPage - startPage)).each {
            collectionsURLList << defBookURL + (it + startPage - 1) * 20
        }
        collectionsURLList.each { collectionsURL->
            commonService.sleepRandomTime(500,2500)
            Document document = Jsoup.connect(collectionsURL).timeout(10000).get()
            def readerDocList = document.select(selector)
            readerDocList.each { readerDoc ->
                if (readerDoc.select("[title=力荐]")||readerDoc.select("[title=推荐]")){
                    def favReaderDoc = readerDoc.select("td a").attr("href")
                    def favReaderId = favReaderDoc.split("people/")[1].replaceAll("/","")
                    def favReaderDouMail = "http://www.douban.com/doumail/write?to=" + favReaderId
                    favReaderDouMailList << favReaderDouMail
                }
            }
        }

        return favReaderDouMailList
    }
}
