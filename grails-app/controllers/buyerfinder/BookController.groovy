package buyerfinder

import book.BookService

class BookController {

    BookService bookService

    def index() {
        redirect(action: "demo")
    }

    def demo() {
    }

    def showBookReader() {
        String bookId = params.bookId
        int startPage = params.startPage.toInteger()
        int endPage = params.endPage.toInteger()
        def favReaderDouMailList = bookService.getFavReader(bookId,startPage,endPage)
        [favReaderDouMailList:favReaderDouMailList]
    }
}
