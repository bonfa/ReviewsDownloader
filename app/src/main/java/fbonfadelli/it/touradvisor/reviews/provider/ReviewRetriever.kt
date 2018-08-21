package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.reviews.ReviewProviderCallback

class ReviewRetriever(private val retrofitReviewsProvider: NetworkReviewsProvider,
                      private val networkReviewsAdapter: NetworkReviewsAdapter) : ReviewProvider {

    override fun getReviews(reviewProviderCallback: ReviewProviderCallback) {
        retrofitReviewsProvider.getReviews(5, 0, object : NetworkReviewsProviderCallback {
            override fun onReviews(reviews: NetworkReviews) {
                val adaptedReviews = networkReviewsAdapter.adapt(reviews)
                if (adaptedReviews.isPresent()) {
                    reviewProviderCallback.onReviews(adaptedReviews)
                } else {
                    reviewProviderCallback.oNoReviews()
                }
            }

            override fun onError() {
                reviewProviderCallback.oNoReviews()
            }
        })
    }

    override fun stop() {
        retrofitReviewsProvider.stop()
    }
}