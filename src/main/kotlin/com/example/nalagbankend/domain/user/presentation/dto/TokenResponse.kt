package com.example.nalagbankend.domain.user.presentation.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TokenResponse(
    val accessToken: String = "",
)