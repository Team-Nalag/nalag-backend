package com.example.nalagbankend.global.utils.openfeign.client

import com.example.nalagbankend.domain.user.presentation.dto.TokenResponse
import com.example.nalagbankend.global.utils.openfeign.GithubRequestConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "GithubTokenFeign", url = "https://github.com", configuration = [GithubRequestConfig::class])
interface GithubTokenFeign {
    @GetMapping("/login/oauth/access_token")
    fun getAccessToken(
        @RequestParam("client_id") clientId: String,
        @RequestParam("client_secret") clientSecret: String,
        @RequestParam("code") code: String
    ): TokenResponse
}