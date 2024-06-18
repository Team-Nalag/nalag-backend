package com.example.nalagbankend.global.utils.openfeign.client

import com.example.nalagbankend.domain.user.presentation.dto.TokenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "GoogleTokenFeign",
    url = "https://oauth2.googleapis.com"
)
interface GoogleTokenFeign {
    @PostMapping("/token", headers = ["Content-Length=0"])
    fun getAccessToken(@RequestParam code: String): TokenResponse
}