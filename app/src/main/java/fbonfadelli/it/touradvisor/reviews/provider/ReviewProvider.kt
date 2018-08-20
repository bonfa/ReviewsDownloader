package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.reviews.ReviewProviderCallback

interface ReviewProvider {
    fun getReviews(reviewProviderCallback: ReviewProviderCallback)
    fun stop()
}
