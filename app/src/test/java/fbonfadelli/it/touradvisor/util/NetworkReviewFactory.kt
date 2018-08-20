package fbonfadelli.it.touradvisor.util

import fbonfadelli.it.touradvisor.reviews.provider.NetworkReviews

public fun expectedNetworkReviews(): NetworkReviews {
    val networkReviews = NetworkReviews()
    networkReviews.totalReviewsComments = 549
    val firstReview = NetworkReviews.NetworkReview()
    firstReview.id = 3452235
    firstReview.rating = 5.0
    firstReview.title = "A Great Insight into the evolution of the Airport"
    firstReview.message = "This was a very educational tour of Templehoff. We saw lots of different sides of the airport. The tour guide was very knowledgable and helpful. We then walked out onto the Runway. A great place to be"
    firstReview.author = "Stefan – United Kingdom"
    firstReview.foreignLanguage = false
    firstReview.date = "August 20, 2018"
    firstReview.languageCode = "en"
    firstReview.travelerType = "family_old"
        firstReview.reviewerName = "Stefan"
    firstReview.reviewerCountry = "United Kingdom"
    networkReviews.reviews = mutableListOf(firstReview).toList()
    return networkReviews
}

public fun emptyNetworkReviews(): NetworkReviews {
    val networkReviews = NetworkReviews()
    networkReviews.totalReviewsComments = 0
    networkReviews.reviews = emptyList()
    return networkReviews
}