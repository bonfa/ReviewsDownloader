package fbonfadelli.it.touradvisor.reviews.provider

import fbonfadelli.it.touradvisor.util.StubbedReviewsLoader
import fbonfadelli.it.touradvisor.util.aNetworkReview
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

        assertThat(reviews, CoreMatchers.`is`(aNetworkReview()))
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