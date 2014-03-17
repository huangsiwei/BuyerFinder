package buyerfinder
import moviefan.MovieFanService

class MoiveFansController {

    MovieFanService movieFanService

    def index() {
        redirect(action: "demo")
    }

    def demo() {
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
