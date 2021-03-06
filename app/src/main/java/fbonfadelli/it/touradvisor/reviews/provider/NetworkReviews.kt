package fbonfadelli.it.touradvisor.reviews.provider

import com.google.gson.annotations.SerializedName

class NetworkReviews {

    @SerializedName("total_reviews_comments")
    var totalReviewsComments: Int? = 0

    @SerializedName("data")
    var reviews: List<NetworkReview>? = emptyList()

    class NetworkReview {
        @SerializedName("review_id")
        var id: Long? = 0L

        @SerializedName("rating")
        var rating: String? = "0.0"

        @SerializedName("title")
        var title: String? = ""

        @SerializedName("message")
        var message: String? = ""

        @SerializedName("author")
        var author: String? = ""

        @SerializedName("foreignLanguage")
        var foreignLanguage: Boolean? = false

        @SerializedName("date")
        var date: String? = ""

        @SerializedName("languageCode")
        var languageCode: String? = ""

        @SerializedName("traveler_type")
        var travelerType: String? = ""

        @SerializedName("reviewerName")
        var reviewerName: String? = ""

        @SerializedName("reviewerCountry")
        var reviewerCountry: String? = ""

        override fun toString(): String {
            return "NetworkReview(id=$id, rating=$rating, title='$title', message='$message', author='$author', foreignLanguage=$foreignLanguage, date='$date', languageCode='$languageCode', travelerType='$travelerType', reviewerName='$reviewerName', reviewerCountry='$reviewerCountry')"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as NetworkReview

            if (id != other.id) return false
            if (rating != other.rating) return false
            if (title != other.title) return false
            if (message != other.message) return false
            if (author != other.author) return false
            if (foreignLanguage != other.foreignLanguage) return false
            if (date != other.date) return false
            if (languageCode != other.languageCode) return false
            if (travelerType != other.travelerType) return false
            if (reviewerName != other.reviewerName) return false
            if (reviewerCountry != other.reviewerCountry) return false

            return true
        }

        override fun hashCode(): Int {
            return 0
        }


    }

    override fun toString(): String {
        return "NetworkReviews(totalReviewsComments=$totalReviewsComments, reviews=$reviews)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NetworkReviews

        if (totalReviewsComments != other.totalReviewsComments) return false
        if (reviews != other.reviews) return false

        return true
    }

    override fun hashCode(): Int {
        return 0
    }


}
