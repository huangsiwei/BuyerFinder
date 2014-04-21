package album

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class AlbumService {

    def countAlbumPageNum (String albumId) {
        String albumURL = "http://www.douban.com/photos/album/" + albumId
        Document document = Jsoup.connect(albumURL).get()
        def pageCount = document.select(".paginator .count").html()
        pageCount = Math.floor(pageCount.replaceAll("[^\\d]+","").toInteger()/18).toInteger()
        return pageCount
    }

    def getPhotoPageList(String albumId,int pageCount) {
        def photoPageList = []
        (0..pageCount).each {
            String albumURL = "http://www.douban.com/photos/album/" + albumId +"/?start=" + it*18
            Document document = Jsoup.connect(albumURL).get()
            def photoPageRawList = document.select(".photolst .photo_wrap a")
            photoPageRawList.each { photoPage ->
                String pageURL = photoPage.attr("href")
                if (!pageURL.contains("#comments")){
                    photoPageList << pageURL
                }
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
