package com.example.nalagbankend.global.security.auth

import com.example.nalagbankend.domain.user.domain.repository.UserRepository
import com.example.nalagbankend.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(name: String): UserDetails {
        val user = userRepository.findByName(name) ?: throw UserNotFoundException
        return AuthDetails(user = user)
    }
}