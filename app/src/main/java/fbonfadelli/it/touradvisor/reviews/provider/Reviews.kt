package fbonfadelli.it.touradvisor.reviews.provider

data class Reviews(
        val totalReviewsComments: Int,
        val reviews: List<Review>
) {
    fun isPresent(): Boolean = reviews.size > 0

    companion object {
        fun empty(): Reviews {
            return Reviews(0, emptyList())
        }
    }
}
