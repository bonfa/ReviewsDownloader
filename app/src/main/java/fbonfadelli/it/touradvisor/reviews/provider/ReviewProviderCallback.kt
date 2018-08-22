package fbonfadelli.it.touradvisor.reviews.provider

interface ReviewProviderCallback {
    fun oNoReviews()
    fun onReviews(reviews: Reviews)
}
