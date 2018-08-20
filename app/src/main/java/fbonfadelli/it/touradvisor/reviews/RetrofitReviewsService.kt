package fbonfadelli.it.touradvisor.reviews

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitReviewsService {

    @GET("berlin-l17/tempelhof-2-hour-airport-history-tour-berlin-airlift-more-t23776/reviews.json")
    fun get(@Query("count") count: Int,
            @Query("page") page: Int)
            : Call<NetworkReviews>
}