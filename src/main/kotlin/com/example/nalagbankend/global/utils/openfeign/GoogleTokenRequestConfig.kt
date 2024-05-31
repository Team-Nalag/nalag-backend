package com.example.nalagbankend.global.utils.openfeign

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GoogleTokenRequestConfig(
    @Value("\${spring.security.oauth2.client.registration.google.client-id}") private val clientId: String,
    @Value("\${spring.security.oauth2.client.registration.google.client-secret}") private val clientSecret: String,
    @Value("\${spring.security.oauth2.client.registration.google.redirect-uri}") private val redirectUri: String,
    @Value("\${spring.security.oauth2.client.registration.google.authorization-grant-type}") private val grantType: String,

    ) {
    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { template: RequestTemplate ->
            template.query("client_id", clientId)
            template.query("client_secret", clientSecret)
            template.query("redirect_uri", redirectUri)
            template.query("grant_type", grantType)
        }
    }
}