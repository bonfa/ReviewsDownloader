package fbonfadelli.it.touradvisor.reviews.provider

import retrofit2.Call

interface NetworkReviewsProvider {
    fun getReviews(count: Int, page: Int): NetworkReviews
    fun stop()
}

class RetrofitReviewsProvider(private val reviewService: RetrofitReviewsService) : NetworkReviewsProvider {

    private var call: Call<NetworkReviews>? = null

    override fun getReviews(count: Int, page: Int): NetworkReviews {
        call = reviewService.get(count, page)

        try {
            val body = call!!.execute().body()
            return if (body != null) body else NetworkReviews()
        }
        catch (e: Exception) {
            if (call!!.isCanceled) {
                throw ProviderInterruptedException("Call cancelled")
            }
            else {
                throw ReviewsProviderException(e)
            }
        }
    }

    override fun stop() {
        call?.cancel()
    }
}