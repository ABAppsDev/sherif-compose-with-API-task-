package com.route.compose_with_api.data.repository

import com.route.compose_with_api.data.datasource.remotedatasource.RemoteDataSource
import com.route.compose_with_api.data.datasource.remotedatasource.RemoteDataSourceImpl
import com.route.compose_with_api.data.model.PostResponse
import com.route.compose_with_api.domain.repository.PostRepository

class PostRepositoryImpl : PostRepository {
    var remoteDataSource : RemoteDataSource = RemoteDataSourceImpl()
    override suspend fun getPosts(): List<PostResponse> {
        return remoteDataSource.getPosts()
    }
}