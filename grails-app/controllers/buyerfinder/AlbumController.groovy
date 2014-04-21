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
        String albumId = params.albumId
        int pageCount = albumService.countAlbumPageNum(albumId)
        def photoPageList =  albumService.getPhotoPageList(albumId,pageCount)
        def douMailList = albumService.getDouMailURL(photoPageList)
        [douMailList:douMailList]
    }
}
