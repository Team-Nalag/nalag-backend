package com.example.nalagbankend.domain.quiz.service

import com.example.nalagbankend.domain.quiz.domain.Quiz
import com.example.nalagbankend.domain.quiz.domain.repository.QuizRepository
import com.example.nalagbankend.domain.quiz.presentation.dto.CreateQuizRequest
import com.example.nalagbankend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateQuizService(
    private val userFacade: UserFacade,
    private val quizRepository: QuizRepository
) {
    @Transactional
    fun execute(request: CreateQuizRequest) {
        val user = userFacade.getCurrentUser()
        quizRepository.save(
            Quiz(
                request.title,
                request.choiceContent1,
                request.choiceContent2,
                request.choiceContent3,
                request.choiceContent4,
                request.choicePhoto1,
                request.choicePhoto2,
                request.choicePhoto3,
                request.choicePhoto4,
                user
            )
        )
    }
}