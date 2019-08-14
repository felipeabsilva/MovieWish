package com.felipesilva.moviewish.remote.config

import com.felipesilva.moviewish.utilities.API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun buildRetrofit() =
        Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}