package com.route.compose_with_api.data.datasource.remotedatasource

import com.route.compose_with_api.data.model.PostResponse
import retrofit2.Call

interface RemoteDataSource {
    suspend fun getPosts() : Call<List<PostResponse>>
}