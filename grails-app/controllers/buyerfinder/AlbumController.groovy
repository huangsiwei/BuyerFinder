package buyerfinder

import album.AlbumService

class AlbumController {

    AlbumService albumService

    def index() {
        redirect(action: "demo")
    }

    def demo() {
    }

    def showReviewer() {
        String albumURL = "http://www.douban.com/photos/album/" + params.albumId
        def photoPageList =  albumService.getPhotoPageList(albumURL)
        def douMailList = albumService.getDouMailURL(photoPageList)
        [douMailList:douMailList]
    }
}
