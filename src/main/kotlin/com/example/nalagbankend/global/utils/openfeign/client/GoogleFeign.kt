package com.example.nalagbankend.global.utils.openfeign.client

import com.example.nalagbankend.global.utils.openfeign.client.dto.GetGoogleUserInfoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "GoogleFeign",
    url = "https://www.googleapis.com"
)
interface GoogleFeign {
    @GetMapping("/oauth2/v3/userinfo")
    fun getGoogleUserInfo(@RequestHeader("Authorization") token: String): GetGoogleUserInfoResponse
}