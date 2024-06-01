package com.example.nalagbankend.domain.answer.domain.repository

import com.example.nalagbankend.domain.answer.domain.Answer
import com.example.nalagbankend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AnswerRepository: JpaRepository<Answer, UUID> {
    fun findAllByUserNot(user: User): List<Answer>
}