package com.example.nalagbankend.global.utils.openfeign.client

data class GetGoogleUserInfoResponse(
    val email: String,
    val picture: String,
    val name: String
)
