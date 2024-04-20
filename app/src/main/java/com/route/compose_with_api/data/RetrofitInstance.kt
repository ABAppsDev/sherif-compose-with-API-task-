package com.route.compose_with_api.data

import com.route.compose_with_api.data.api.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    val api : WebService by lazy {
        val retrofit  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(WebService::class.java)
    }
}