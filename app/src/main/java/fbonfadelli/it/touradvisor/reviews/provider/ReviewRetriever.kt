package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.reviews.ReviewProviderCallback

class ReviewRetriever(private val retrofitReviewsProvider: NetworkReviewsProvider,
                      private val networkReviewsAdapter: NetworkReviewsAdapter) : ReviewProvider {

    override fun getReviews(reviewProviderCallback: ReviewProviderCallback) {
        val reviews = networkReviewsAdapter.adapt(
                retrofitReviewsProvider.getReviews(1, 5)
        )
        if (reviews.isPresent()) {
            reviewProviderCallback.onReviews(reviews)
        }
        else {
            reviewProviderCallback.oNoReviews()
        }
    }

    override fun stop() {
        retrofitReviewsProvider.stop()
    }

}