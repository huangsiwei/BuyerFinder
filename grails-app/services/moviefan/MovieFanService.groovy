package moviefan

import buyerfinder.MovieReview
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MovieFanService {

    def getMovieReview(basicURL,pageCount) {
        def nextPageURL = basicURL + "?sort=time"
        (0..pageCount-1).each {
            Document document = Jsoup.connect(nextPageURL).get()
            def nextPage = document.select("#paginator").select('.next').attr('href')
            nextPageURL = basicURL + nextPage
            println(nextPageURL)
            def movieName = document.select("#content").select("h1").html().split(" ")[0]
            def commentInstanceList = document.select(".comment-info")
            commentInstanceList.each { commentInstance ->
                MovieReview movieReview = new MovieReview()
                movieReview.userName = commentInstance.childNodes()[1].childNodes()[0]
                movieReview.homePage = commentInstance.childNodes()[1].attr("href").replaceAll("movie","www")
                if (commentInstance.childNodes()[3].attr("title")) {
                    movieReview.score = commentInstance.childNodes()[3].attr("title")
                } else {
                    movieReview.score = "未评分"
                }
                if (commentInstance.childNodes()[5]) {
                    movieReview.reviewDate = Date.parse("yyyy-MM-dd",commentInstance.childNodes()[5].childNodes()[0].toString().replaceAll(" ",""))
                } else {
                    movieReview.reviewDate
                }
                movieReview.movieName = movieName
                movieReview.save()
            }
        }
    }

}
