package fbonfadelli.it.touradvisor.reviews

import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider
import fbonfadelli.it.touradvisor.reviews.provider.Reviews

class ReviewsPresenter(private val reviewsView: ReviewsView, val reviewProvider: ReviewProvider) : ReviewProviderCallback {
    fun onResume() {
        reviewsView.showLoading()
        reviewProvider.getReviews(this)
    }

    override fun onReviews(reviews: Reviews) {
        reviewsView.showReviews(reviews)
        reviewsView.hideLoading()
    }

    override fun oNoReviews() {
        reviewsView.showNoReviews()
        reviewsView.hideLoading()
    }

    fun onPause() {
        reviewsView.hideLoading()
        reviewProvider.stop()
    }
}
