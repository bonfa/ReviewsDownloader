package fbonfadelli.it.touradvisor.reviews

import fbonfadelli.it.touradvisor.reviews.provider.Reviews

interface ReviewProviderCallback {
    fun oNoReviews()
    fun onReviews(reviews: Reviews)
}
