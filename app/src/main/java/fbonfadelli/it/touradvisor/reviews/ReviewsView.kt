package fbonfadelli.it.touradvisor.reviews

import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider
import fbonfadelli.it.touradvisor.reviews.provider.Reviews

interface ReviewsView {
    fun showLoading()
    fun hideLoading()

    fun showReviews(reviews: Reviews)
    fun showNoReviews()
    fun showStrategy(reviewStrategy: ReviewProvider.Strategy)
}