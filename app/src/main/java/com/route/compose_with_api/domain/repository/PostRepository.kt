package com.route.compose_with_api.domain.repository

import com.route.compose_with_api.data.model.PostResponse
import retrofit2.Call

interface PostRepository {
    suspend fun getPosts() : Call<List<PostResponse>>
}