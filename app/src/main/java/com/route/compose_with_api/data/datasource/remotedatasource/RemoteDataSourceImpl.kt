package com.route.compose_with_api.data.datasource.remotedatasource

import com.route.compose_with_api.data.api.WebService
import com.route.compose_with_api.data.model.PostResponse

class RemoteDataSourceImpl : RemoteDataSource {
    lateinit var webService: WebService
    override suspend fun getPosts()  : List<PostResponse>{
        return webService.getPosts()
    }
}