package fbonfadelli.it.touradvisor.reviews

class ReviewsPresenter(private val reviewsView: ReviewsView, val reviewProvider: ReviewProvider) {
    fun onResume() {
        reviewsView.showLoading()
        reviewProvider.getReviews()
    }

    fun onReviews(reviews: Reviews) {
        reviewsView.showReviews(reviews)
        reviewsView.hideLoading()
    }
}
