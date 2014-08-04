package moviefan

import buyerfinder.MovieReview
import common.CommonService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MovieFanService {

    CommonService commonService

    def getMovieReview(basicURL,pageCount) {
        def nextPageURL = basicURL + "?sort=time"
        (0..pageCount-1).each {
            commonService.sleepRandomTime(500,2500)
            Document document = Jsoup.connect(nextPageURL).get()
            def nextPage = document.select("#paginator").select('.next').attr('href')
            nextPageURL = basicURL + nextPage
            println(nextPageURL)
            def movieName = document.select("#content").select("h1").html().split(" ")[0]
            def commentInstanceList = document.select(".comment-item")
            commentInstanceList.each { commentInstance ->
                MovieReview movieReview = new MovieReview()
                movieReview.userName = commentInstance.select("a").attr("title")
                movieReview.homePage = commentInstance.select("a").attr("href")
                if (commentInstance.select(".comment span").attr("title")) {
                    movieReview.score = commentInstance.select(".comment h3 .comment-info").select("span").attr("title")
                } else {
                    movieReview.score = "未评分"
                }
                movieReview.content = commentInstance.select("p").html()
                if (commentInstance.select(".comment h3 .comment-info").select("span")[2]) {
                    movieReview.reviewDate = Date.parse("yyyy-MM-dd",commentInstance.select(".comment h3 .comment-info").select("span")[2].html())
                } else {
                    movieReview.reviewDate
                }
                movieReview.movieName = movieName
                movieReview.save()
            }
        }
    }

}
