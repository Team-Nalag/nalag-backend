package com.example.nalagbankend.domain.quiz.service

import com.example.nalagbankend.domain.answer.domain.repository.AnswerRepository
import com.example.nalagbankend.domain.quiz.domain.repository.ChoiceRepository
import com.example.nalagbankend.domain.quiz.domain.repository.QuizRepository
import com.example.nalagbankend.domain.quiz.exception.QuizNotFoundException
import com.example.nalagbankend.domain.quiz.presentation.dto.ChoiceElement
import com.example.nalagbankend.domain.quiz.presentation.dto.QueryQuizDetailResponse
import com.example.nalagbankend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryQuizDetailService(
    private val quizRepository: QuizRepository,
    private val choiceRepository: ChoiceRepository
) {
    @Transactional(readOnly = true)
    fun execute(): QueryQuizDetailResponse {
        val quizzes = quizRepository.findAll()
        val quiz = quizzes.random()
        val choices = choiceRepository.findAllByQuiz(quiz).map {
            ChoiceElement(it.id, it.content, it.photo)
        }

        return QueryQuizDetailResponse(quiz.title, quiz.id, choices)
    }
}