package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.reviews.ReviewProviderCallback

private const val numberOfResult = 10
private const val page = 0

class ReviewRetriever(private val retrofitReviewsProvider: NetworkReviewsProvider,
                      private val networkReviewsAdapter: NetworkReviewsAdapter) : ReviewProvider {

    override fun getReviews(reviewStrategy: ReviewProvider.Strategy,
                            reviewProviderCallback: ReviewProviderCallback) {
        retrofitReviewsProvider.getReviews(
                numberOfResult,
                page,
                reviewStrategy,
                object : NetworkReviewsProviderCallback {
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