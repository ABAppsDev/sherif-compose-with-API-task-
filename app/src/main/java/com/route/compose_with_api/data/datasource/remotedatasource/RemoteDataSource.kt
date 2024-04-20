package com.route.compose_with_api.data.datasource.remotedatasource

import com.route.compose_with_api.data.model.PostResponse

interface RemoteDataSource {
    suspend fun getPosts() : List<PostResponse>
}