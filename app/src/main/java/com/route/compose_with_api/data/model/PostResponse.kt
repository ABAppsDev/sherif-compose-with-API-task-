package com.route.compose_with_api.data.model

data class PostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)