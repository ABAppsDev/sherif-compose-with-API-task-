package com.route.compose_with_api.data.api

import com.route.compose_with_api.data.model.PostResponse
import retrofit2.http.GET

interface WebService {
    @GET("posts")
    suspend fun getPosts() : List<PostResponse>
}