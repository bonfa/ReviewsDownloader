package fbonfadelli.it.touradvisor.reviews.provider

interface ReviewProvider {
    fun getReviews(reviewStrategy: Strategy, reviewProviderCallback: ReviewProviderCallback)
    fun stop()

    enum class Strategy {
        RATING_STRATEGY_DESC,
        RATING_STRATEGY_ASC
    }
}
