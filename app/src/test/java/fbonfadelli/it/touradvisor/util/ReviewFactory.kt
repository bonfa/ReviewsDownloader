package fbonfadelli.it.touradvisor.util

import fbonfadelli.it.touradvisor.reviews.provider.Review
import fbonfadelli.it.touradvisor.reviews.provider.Reviews

public fun expectedReviews(): Reviews {
    return Reviews(
            549,
            mutableListOf(
                    Review(
                            3452235,
                            5.0,
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
            )
    )
}

public fun emptyReviews() : Reviews {
    return Reviews(
            0,
            emptyList()
    )
}