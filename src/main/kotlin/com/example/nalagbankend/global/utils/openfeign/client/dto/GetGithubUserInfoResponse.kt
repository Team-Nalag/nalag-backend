package com.example.nalagbankend.global.utils.openfeign.client.dto

data class GetGithubUserInfoResponse(
    val login: String = "",
    val email: String = "",
    val followers: Int = 0,
    val avatarUrl: String = "",
)
