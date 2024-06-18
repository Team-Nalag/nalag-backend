package com.example.nalagbankend.domain.user.domain.repository

import com.example.nalagbankend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID
import javax.validation.constraints.Email

interface UserRepository: JpaRepository<User, UUID> {
    fun findByName(email: String): User?
    fun existsByName(email: String): Boolean
}