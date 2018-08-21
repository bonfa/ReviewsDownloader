package fbonfadelli.it.touradvisor.reviews.provider

import com.google.gson.GsonBuilder

import java.util.concurrent.TimeUnit

import fbonfadelli.it.touradvisor.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitReviewsServiceFactory {

    private val restAdapterWithConverter: Retrofit
        get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createHttpClient(createInterceptor()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()

    fun create(): RetrofitReviewsService {
        return restAdapterWithConverter.create(RetrofitReviewsService::class.java)
    }

    private fun createHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(TIMEOUT_READ.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_WRITE.toLong(), TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECT.toLong(), TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
    }

    private fun createInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return interceptor
    }

    companion object {

        private val TIMEOUT_READ = 15
        private val TIMEOUT_WRITE = 15
        private val TIMEOUT_CONNECT = 15
        private val BASE_URL = "https://www.getyourguide.com/"
    }
}
