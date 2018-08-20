package fbonfadelli.it.touradvisor.reviews

interface ReviewsView {
    fun showLoading()
    fun hideLoading()

    fun showReviews(reviews: Reviews)
    fun showNoReviews()
}