package com.felipesilva.moviewish.remote.config

import android.content.Context
import com.felipesilva.moviewish.utilities.API
import com.felipesilva.moviewish.utilities.isConnectedToNetwork
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig(context: Context) {
    private var retrofit: Retrofit? = null
    private val cacheSize = (10 * 1024 * 1024).toLong()
    private val cache = Cache(context.cacheDir, cacheSize)

    private val okHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor { chain ->
            var request = chain.request()

            request = if (context.isConnectedToNetwork())
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header(
                    "Cache-Control",
                    "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                ).build()

            chain.proceed(request)
        }
        .build()

    fun buildRetrofit() : Retrofit {
        if (retrofit == null) {
           retrofit = Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!
    }
}