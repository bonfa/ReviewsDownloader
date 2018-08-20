package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.loader.StubbedReviewsLoader
import okhttp3.Request
import org.hamcrest.CoreMatchers
import org.junit.Assert.assertThat
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitReviewsProviderTest {

    private val reviewService = RetrofitReviewsServiceStub()
    private val retrofitReviewsProvider = RetrofitReviewsProvider(reviewService)

    @Test
    fun getReviews() {
        val reviews = retrofitReviewsProvider.getReviews(0, 5)

        assertThat(reviews, CoreMatchers.`is`(expectedReviews()))
    }

    private fun expectedReviews(): NetworkReviews {
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

    private inner class RetrofitReviewsServiceStub internal constructor() : RetrofitReviewsService {

        private val stubbedReviewsLoader = StubbedReviewsLoader()

        override fun get(count: Int, page: Int): Call<NetworkReviews> {
            return object : Call<NetworkReviews> {
                override fun execute(): Response<NetworkReviews> {
                    return Response.success(stubbedReviewsLoader.loadStubbedReviews())
                }

                override fun enqueue(callback: Callback<NetworkReviews>) {
                    //nothing to do here
                }

                override fun isExecuted(): Boolean {
                    return false
                }

                override fun cancel() {
                    //nothing to do here
                }

                override fun isCanceled(): Boolean {
                    return false
                }

                override fun clone(): Call<NetworkReviews> {
                    TODO("not implemented")
                }

                override fun request(): Request? {
                    return null
                }
            }
        }
    }
}