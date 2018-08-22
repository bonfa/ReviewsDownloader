package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.reviews.ReviewProviderCallback

interface ReviewProvider {
    fun getReviews(reviewStrategy: Strategy, reviewProviderCallback: ReviewProviderCallback)
    fun stop()

    enum class Strategy {
        RATING_STRATEGY_DESC,
        RATING_STRATEGY_ASC
    }
}
