package com.route.compose_with_api.domain.repository

import com.route.compose_with_api.data.model.PostResponse

interface PostRepository {
    suspend fun getPosts() : List<PostResponse>
}