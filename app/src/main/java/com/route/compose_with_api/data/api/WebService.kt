package com.route.compose_with_api.data.api

import com.route.compose_with_api.data.model.CatRespose
import retrofit2.http.GET

interface WebService {
    @GET("/users")
    suspend fun getCatData() : List<CatRespose>
}