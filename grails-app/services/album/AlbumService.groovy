package album

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class AlbumService {

    def getPhotoPageList(String albumURL) {
        Document document = Jsoup.connect(albumURL).timeout(10000).get()
        def albumName = document.select("#content .info h1").html()
        def photoPageRawList = document.select(".photolst .photo_wrap a")
        def photoPageList = []
        photoPageRawList.each { photoPage ->
            String pageURL = photoPage.attr("href")
            if (!pageURL.contains("#comments")){
                photoPageList << pageURL
            }
        }
        return photoPageList
    }

    def getDouMailURL(List photoPageList) {
        def userList = []
        def douMailURLList = []
        photoPageList.each { pohotPage ->
            Document document = Jsoup.connect(pohotPage).timeout(10000).get()
            document.select(".content .author a").each { userRawURL ->
                userList << userRawURL.attr("href")
            }
        }
        userList.each { String userURL ->
            Document document = Jsoup.connect(userURL).timeout(10000).get()
            def userPhotoURL = document.select("#profile .infobox .bd img").attr("src").split("icon/ul")
            if (userPhotoURL.size()==2) {
                println(userPhotoURL)
                String userId = userPhotoURL[1].split("-")[0]
                def douMailURL = "http://www.douban.com/doumail/write?to=" + userId
                douMailURLList << douMailURL
            }
        }
        return douMailURLList
    }
}
