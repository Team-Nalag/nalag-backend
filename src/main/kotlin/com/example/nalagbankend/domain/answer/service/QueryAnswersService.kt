package com.example.nalagbankend.domain.answer.service

import com.example.nalagbankend.domain.answer.domain.repository.AnswerRepository
import com.example.nalagbankend.domain.answer.presentation.dto.AnswersElement
import com.example.nalagbankend.domain.answer.presentation.dto.QueryAnswersResponse
import com.example.nalagbankend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryAnswersService(
    private val userFacade: UserFacade,
    private val answerRepository: AnswerRepository
) {
    @Transactional(readOnly = true)
    fun execute(): QueryAnswersResponse {
        val user = userFacade.getCurrentUser()
        val answers = answerRepository.findAll()
        return QueryAnswersResponse(
            answers.map {
                AnswersElement(it.id, it.user.name, it.quiz.title)
            }
        )
    }
}