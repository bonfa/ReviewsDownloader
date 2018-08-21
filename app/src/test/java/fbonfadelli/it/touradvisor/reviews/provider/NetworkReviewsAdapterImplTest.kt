package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.util.aNetworkReview
import fbonfadelli.it.touradvisor.util.aReview
import fbonfadelli.it.touradvisor.util.someNetworkReviews
import fbonfadelli.it.touradvisor.util.someReviews
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class NetworkReviewsAdapterImplTest {
    val networkReviewsAdapter = NetworkReviewsAdapterImpl()

    @Test
    fun nullToEmpty() {
        val reviews = networkReviewsAdapter.adapt(NetworkReviews())

        assertThat(reviews, `is`(Reviews.empty()))
    }

    @Test
    fun oneItem() {
        val reviews = networkReviewsAdapter.adapt(aNetworkReview())

        assertThat(reviews, `is`(aReview()))
    }

    @Test
    fun moreItems() {
        val reviews = networkReviewsAdapter.adapt(someNetworkReviews())

        assertThat(reviews, `is`(someReviews()))
    }

}