package fbonfadelli.it.touradvisor.reviews

import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider
import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider.Strategy.RATING_STRATEGY_ASC
import fbonfadelli.it.touradvisor.reviews.provider.ReviewProvider.Strategy.RATING_STRATEGY_DESC
import fbonfadelli.it.touradvisor.reviews.provider.ReviewProviderCallback
import fbonfadelli.it.touradvisor.reviews.provider.Reviews

class ReviewsPresenter(private val reviewsView: ReviewsView,
                       private val reviewProvider: ReviewProvider) : ReviewProviderCallback {

    private var reviewStrategy: ReviewProvider.Strategy = RATING_STRATEGY_DESC

    fun onResume() {
        showLoadingAskForReviewsAndUpdateStrategy()
    }

    private fun showLoadingAskForReviewsAndUpdateStrategy() {
        reviewsView.showLoading()
        reviewProvider.getReviews(this.reviewStrategy, this)
    }

    override fun onReviews(reviews: Reviews) {
        reviewsView.showReviews(reviews)
        reviewsView.showStrategy(reviewStrategy)
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

    fun toogleRatingSearch() {
        this.reviewStrategy = if (reviewStrategy == RATING_STRATEGY_DESC) RATING_STRATEGY_ASC else RATING_STRATEGY_DESC
        showLoadingAskForReviewsAndUpdateStrategy()
    }
}
