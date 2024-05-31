package com.example.nalagbankend.domain.user.domain.repository

import com.example.nalagbankend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID
import javax.validation.constraints.Email

interface UserRepository: JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?
    fun existsByEmail(email: String): Boolean
}