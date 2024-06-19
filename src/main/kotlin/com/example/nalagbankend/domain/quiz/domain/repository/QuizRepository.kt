package com.example.nalagbankend.domain.quiz.domain.repository

import com.example.nalagbankend.domain.quiz.domain.Quiz
import com.example.nalagbankend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface QuizRepository : JpaRepository<Quiz, UUID> {
    fun findQuizById(id: UUID): Quiz?
}