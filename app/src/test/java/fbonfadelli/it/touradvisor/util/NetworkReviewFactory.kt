package fbonfadelli.it.touradvisor.util

import fbonfadelli.it.touradvisor.reviews.provider.NetworkReviews

fun aNetworkReview(): NetworkReviews {
    val networkReviews = NetworkReviews()
    networkReviews.totalReviewsComments = 549
    networkReviews.reviews = mutableListOf(createNetworkReview()).toList()
    return networkReviews
}

fun someNetworkReviews(): NetworkReviews {
    val networkReviews = NetworkReviews()
    networkReviews.totalReviewsComments = 2
    networkReviews.reviews =
            mutableListOf(
                    createNetworkReview(),
                    createAnotherNetworkReview()
            )
                    .toList()
    return networkReviews
}

private fun createNetworkReview(): NetworkReviews.NetworkReview {
    val review = NetworkReviews.NetworkReview()
    review.id = 3452235
    review.rating = 5.0
    review.title = "A Great Insight into the evolution of the Airport"
    review.message = "This was a very educational tour of Templehoff. We saw lots of different sides of the airport. The tour guide was very knowledgable and helpful. We then walked out onto the Runway. A great place to be"
    review.author = "Stefan – United Kingdom"
    review.foreignLanguage = false
    review.date = "August 20, 2018"
    review.languageCode = "en"
    review.travelerType = "family_old"
    review.reviewerName = "Stefan"
    review.reviewerCountry = "United Kingdom"
    return review
}

fun createAnotherNetworkReview(): NetworkReviews.NetworkReview {
    val review = NetworkReviews.NetworkReview()
    review.id = 3425187
    review.rating = 5.0
    review.title = ""
    review.message = "Tres bon guide, plein de joie de vivre et très dynamique. A faire!!"
    review.author = "Cecile – France"
    review.foreignLanguage = true
    review.date = "August 18, 2018"
    review.languageCode = "fr"
    review.travelerType = "couple"
    review.reviewerName = "Cecile"
    review.reviewerCountry = "France"
    return review
}

fun emptyNetworkReviews(): NetworkReviews {
    val networkReviews = NetworkReviews()
    networkReviews.totalReviewsComments = 0
    networkReviews.reviews = emptyList()
    return networkReviews
}