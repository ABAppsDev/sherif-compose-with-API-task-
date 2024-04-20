package com.route.compose_with_api.data.datasource.remotedatasource

import com.route.compose_with_api.data.api.WebService
import com.route.compose_with_api.data.model.PostResponse
import retrofit2.Call

class RemoteDataSourceImpl : RemoteDataSource {
    lateinit var webService: WebService
    override suspend fun getPosts()  : Call<List<PostResponse>> {
        return webService.getPosts()
    }
}