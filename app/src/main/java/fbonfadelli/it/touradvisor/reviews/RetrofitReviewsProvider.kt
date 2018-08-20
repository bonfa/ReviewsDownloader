package fbonfadelli.it.touradvisor.reviews

import retrofit2.Call

class RetrofitReviewsProvider(private val reviewService: RetrofitReviewsService) {

    private var call: Call<NetworkReviews>? = null

    fun getReviews(count: Int, page: Int): NetworkReviews? {
        call = reviewService.get(count, page)

        try {
            return call!!.execute().body();
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

    fun stop() {
        call?.cancel()
    }
}