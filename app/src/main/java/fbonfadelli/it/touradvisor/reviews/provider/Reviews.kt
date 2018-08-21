package fbonfadelli.it.touradvisor.reviews.provider

data class Reviews(
        private val totalReviewsComments: Int,
        private val reviews: List<Review>
) {
    fun isPresent(): Boolean = reviews.size > 0

    companion object {
        fun empty(): Reviews {
            return Reviews(0, emptyList())
        }
    }
}
