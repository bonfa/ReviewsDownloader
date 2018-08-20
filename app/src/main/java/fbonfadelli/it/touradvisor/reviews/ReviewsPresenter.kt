package fbonfadelli.it.touradvisor.reviews

import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider
import fbonfadelli.it.touradvisor.reviews.provider.Reviews

class ReviewsPresenter(private val reviewsView: ReviewsView, val reviewProvider: ReviewProvider) {
    fun onResume() {
        reviewsView.showLoading()
        reviewProvider.getReviews()
    }

    fun onReviews(reviews: Reviews) {
        reviewsView.showReviews(reviews)
        reviewsView.hideLoading()
    }

    fun oNoReviews() {
        reviewsView.showNoReviews()
        reviewsView.hideLoading()
    }

    fun onPause() {
        reviewsView.hideLoading()
        reviewProvider.stop()
    }
}
