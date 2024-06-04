package com.example.nalagbankend.domain.user.service

import com.example.nalagbankend.domain.user.domain.User
import com.example.nalagbankend.domain.user.domain.repository.UserRepository
import com.example.nalagbankend.domain.user.presentation.dto.TokenResponse
import com.example.nalagbankend.global.security.jwt.JwtTokenProvider
import com.example.nalagbankend.global.utils.openfeign.client.GoogleFeign
import com.example.nalagbankend.global.utils.openfeign.client.GoogleTokenFeign
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GoogleOAuthService(
    private val jwtTokenProvider: JwtTokenProvider,
    private val googleTokenFeign: GoogleTokenFeign,
    private val googleFeign: GoogleFeign,
    private val userRepository: UserRepository,
) {
    @Transactional
    fun execute(code: String): TokenResponse {
        val token = googleTokenFeign.getAccessToken(code).accessToken
        val googleUser = googleFeign.getGoogleUserInfo("Bearer $token")

        return if (userRepository.existsByEmail(googleUser.email)) {
            jwtTokenProvider.generateToken(googleUser.email)
        } else {
            val user = userRepository.save(User(googleUser.email, googleUser.name, googleUser.picture))
            jwtTokenProvider.generateToken(user.email)
        }
    }
}