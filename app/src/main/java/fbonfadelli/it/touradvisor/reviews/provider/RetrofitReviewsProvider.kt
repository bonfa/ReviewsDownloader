package fbonfadelli.it.touradvisor.reviews.provider

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NetworkReviewsProvider {
    fun getReviews(count: Int, page: Int, callback: NetworkReviewsProviderCallback)
    fun stop()
}

interface NetworkReviewsProviderCallback {
    fun onReviews(reviews: NetworkReviews)
    fun onError()
}

class RetrofitReviewsProvider(private val reviewService: RetrofitReviewsService) : NetworkReviewsProvider, Callback<NetworkReviews> {
    private lateinit var callback: NetworkReviewsProviderCallback
    private lateinit var call: Call<NetworkReviews>

    override fun getReviews(count: Int, page: Int, callback: NetworkReviewsProviderCallback) {
        this.callback = callback
        this.call = reviewService.get(count, page)
        this.call.enqueue(this)
    }

    override fun stop() {
        this.call.cancel()
    }

    override fun onResponse(call: Call<NetworkReviews>?, response: Response<NetworkReviews>?) {
        if (call != null && !call.isCanceled && response != null && response.isSuccessful && response.body() != null) {
            callback.onReviews(response.body() as NetworkReviews)
        }
    }

    override fun onFailure(call: Call<NetworkReviews>?, t: Throwable?) {
        if (call != null && !call.isCanceled) {
            callback.onError()
        }
    }
}