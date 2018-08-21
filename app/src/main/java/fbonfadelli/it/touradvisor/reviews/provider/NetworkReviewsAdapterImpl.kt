package fbonfadelli.it.touradvisor.reviews.provider

class NetworkReviewsAdapterImpl : NetworkReviewsAdapter {
    override fun adapt(networkReviews: NetworkReviews): Reviews {

        return if (networkReviews.totalReviewsComments > 0)
            Reviews(
                    networkReviews.totalReviewsComments,
                    adaptReviews(networkReviews.reviews)
            ) else
            Reviews.empty()
    }

    private fun adaptReviews(networkReviews: List<NetworkReviews.NetworkReview>): List<Review> {
        return networkReviews.map { networkReview ->
            Review(
                    networkReview.id,
                    networkReview.rating,
                    networkReview.title,
                    networkReview.message,
                    networkReview.author,
                    networkReview.foreignLanguage,
                    networkReview.date,
                    networkReview.languageCode,
                    networkReview.travelerType,
                    networkReview.reviewerName,
                    networkReview.reviewerCountry
            )
        }
    }
}