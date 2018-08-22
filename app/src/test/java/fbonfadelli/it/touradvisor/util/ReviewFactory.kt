package fbonfadelli.it.touradvisor.util

import fbonfadelli.it.touradvisor.reviews.provider.Review
import fbonfadelli.it.touradvisor.reviews.provider.Reviews

fun aReview(): Reviews {
    return Reviews(
            549,
            mutableListOf(
                    createReview()
            )
    )
}

fun someReviews(): Reviews {
    return Reviews(
            2,
            mutableListOf(
                    createReview(),
                    createAnotherReview()
            )
    )
}

private fun createReview(): Review {
    return Review(
            3452235,
            "5.0",
            "A Great Insight into the evolution of the Airport",
            "This was a very educational tour of Templehoff. We saw lots of different sides of the airport. The tour guide was very knowledgable and helpful. We then walked out onto the Runway. A great place to be",
            "Stefan – United Kingdom",
            false,
            "August 20, 2018",
            "en",
            "family_old",
            "Stefan",
            "United Kingdom"
    )
}

private fun createAnotherReview(): Review {
    return Review(
            3425187,
            "5.0",
            "",
            "Tres bon guide, plein de joie de vivre et très dynamique. A faire!!",
            "Cecile – France",
            true,
            "August 18, 2018",
            "fr",
            "couple",
            "Cecile",
            "France"
    )
}

fun emptyReviews() : Reviews {
    return Reviews(
            0,
            emptyList()
    )
}