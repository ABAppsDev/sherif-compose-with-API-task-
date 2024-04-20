package com.route.compose_with_api.domain.usecase

import com.route.compose_with_api.data.model.PostResponse
import com.route.compose_with_api.data.repository.PostRepositoryImpl
import com.route.compose_with_api.domain.repository.PostRepository
import retrofit2.Call

class UseCase {
    private val postRepo : PostRepository = PostRepositoryImpl()
    suspend fun execute() : Call<List<PostResponse>> {
        return postRepo.getPosts()
    }
}