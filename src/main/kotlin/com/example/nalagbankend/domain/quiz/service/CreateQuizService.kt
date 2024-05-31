package com.example.nalagbankend.domain.quiz.service

import com.example.nalagbankend.domain.quiz.domain.Choice
import com.example.nalagbankend.domain.quiz.domain.Quiz
import com.example.nalagbankend.domain.quiz.domain.repository.ChoiceRepository
import com.example.nalagbankend.domain.quiz.domain.repository.QuizRepository
import com.example.nalagbankend.domain.quiz.exception.SizeBadRequestException
import com.example.nalagbankend.domain.quiz.presentation.dto.CreateQuizRequest
import com.example.nalagbankend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateQuizService(
    private val userFacade: UserFacade,
    private val quizRepository: QuizRepository,
    private val choiceRepository: ChoiceRepository
) {
    @Transactional
    fun execute(request: CreateQuizRequest) {
        val user = userFacade.getCurrentUser()

        if(request.choice.size > 4) {
            throw SizeBadRequestException
        }

        val quiz = quizRepository.save(Quiz(request.title, user))
        request.choice.map { choiceRepository.save(Choice(it.content, it.photo, quiz)) }
    }
}