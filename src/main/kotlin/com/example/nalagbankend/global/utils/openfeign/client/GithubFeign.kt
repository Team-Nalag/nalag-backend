package com.example.nalagbankend.global.utils.openfeign.client

import com.example.nalagbankend.global.utils.openfeign.GithubRequestConfig
import com.example.nalagbankend.global.utils.openfeign.client.dto.GetGithubUserInfoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "GithubTokenFeign", url = "https://api.github.com", configuration = [GithubRequestConfig::class])
interface GithubFeign {
    @GetMapping("/user")
    fun getUserInfo(@RequestHeader("Authorization") authorization: String): GetGithubUserInfoResponse
}