package com.route.compose_with_api.data.model

data class CatRespose(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val deleted: Boolean,
    val email: String,
    val google: Google,
    val ip: String,
    val isAdmin: Boolean,
    val name: Name,
    val phone: String,
    val photo: String,
    val updatedAt: String
)