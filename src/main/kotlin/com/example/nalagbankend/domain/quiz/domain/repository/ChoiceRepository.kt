package com.example.nalagbankend.domain.quiz.domain.repository

import com.example.nalagbankend.domain.quiz.domain.Choice
import com.example.nalagbankend.domain.quiz.domain.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ChoiceRepository : JpaRepository<Choice, UUID> {
    fun findChoiceById(id: UUID): Choice?
    fun findAllByQuiz(quiz: Quiz): List<Choice>
}