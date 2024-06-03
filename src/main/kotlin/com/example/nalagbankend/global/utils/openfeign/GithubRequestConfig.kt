package com.example.nalagbankend.global.utils.openfeign

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GithubRequestConfig {
    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { template: RequestTemplate ->
            template.header("Accept", "application/json")
        }
    }
}