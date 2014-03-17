package buyerfinder

class MovieReview {

    String movieName
    String userName
    String homePage
    String score
    Date reviewDate

    static constraints = {
        reviewDate nullable: true
    }
}
