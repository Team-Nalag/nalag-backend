package com.example.nalagbankend.domain.user.service

import com.example.nalagbankend.domain.user.domain.User
import com.example.nalagbankend.domain.user.domain.repository.UserRepository
import com.example.nalagbankend.domain.user.presentation.dto.TokenResponse
import com.example.nalagbankend.global.security.jwt.JwtTokenProvider
import com.example.nalagbankend.global.utils.openfeign.client.GithubFeign
import com.example.nalagbankend.global.utils.openfeign.client.GithubTokenFeign
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GithubOAuthService(
    @Value("\${spring.security.oauth2.client.registration.github.client-id}")
    private val clientId: String,
    @Value("\${spring.security.oauth2.client.registration.github.client-secret}")
    private val clientSecret: String,
    private val jwtTokenProvider: JwtTokenProvider,
    private val githubTokenFeign: GithubTokenFeign,
    private val githubFeign: GithubFeign,
    private val userRepository: UserRepository,
) {
    @Transactional
    fun execute(code: String): TokenResponse {
        val token = githubTokenFeign.getAccessToken(clientId, clientSecret, code).accessToken
        val githubUser = githubFeign.getUserInfo("Bearer $token")

        return if (userRepository.existsByEmail(githubUser.email)) {
            jwtTokenProvider.generateToken(githubUser.email)
        } else {
            val user = userRepository.save(User(githubUser.email, githubUser.login, githubUser.avatarUrl))
            jwtTokenProvider.generateToken(user.email)
        }
    }
}