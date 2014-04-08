package buyerfinder

class MovieReview {

    String movieName
    String userName
    String homePage
    String score
    String content
    Date reviewDate

    static constraints = {
        reviewDate nullable: true
    }
}
