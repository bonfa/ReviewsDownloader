package fbonfadelli.it.touradvisor.reviews.provider

interface NetworkReviewsAdapter {
    fun adapt(networkReviews: NetworkReviews): Reviews
}
