package com.example.nalagbankend.domain.user.facade

import com.example.nalagbankend.domain.user.domain.User
import com.example.nalagbankend.domain.user.domain.repository.UserRepository
import com.example.nalagbankend.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val name: String = SecurityContextHolder.getContext().authentication.name
        return getByName(name)
    }

    fun getByName(name: String): User {
        return userRepository.findByName(name) ?: throw UserNotFoundException
    }
}