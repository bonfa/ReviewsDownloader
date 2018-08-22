package fbonfadelli.it.touradvisor.reviews.provider

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitReviewsService {

    @Headers("Accept: application/json", "User-Agent: GetYourGuide")
    @GET("berlin-l17/tempelhof-2-hour-airport-history-tour-berlin-airlift-more-t23776/reviews.json")
    fun get(@Query("count") count: Int,
            @Query("page") page: Int,
            @Query("sortBy") sortBy: String,
            @Query("direction") direction: String
    ): Call<NetworkReviews>


}