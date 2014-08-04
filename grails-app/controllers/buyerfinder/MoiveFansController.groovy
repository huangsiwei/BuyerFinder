package buyerfinder
import moviefan.MovieFanService
import senddoumail.SendDouMailService

class MoiveFansController {

    MovieFanService movieFanService
    SendDouMailService sendDouMailService

    def index() {
        redirect(action: "demo")
    }

    def demo() {
    }

    def testLogin() {
        sendDouMailService.testLogin()
    }

    def showMovieFans() {
        String basicURL = params.url
        int pageCount = params.pageCount.toInteger()
        movieFanService.getMovieReview(basicURL,pageCount)
        redirect(action: "showResult")
    }

    def showResult() {
        List<MovieReview> movieReviewList = MovieReview.list()
        def movieName = movieReviewList[0].movieName
        [movieReviewList:movieReviewList,movieName:movieName]
    }
}
