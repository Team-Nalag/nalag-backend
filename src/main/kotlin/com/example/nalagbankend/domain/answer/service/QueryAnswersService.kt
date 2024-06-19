package com.example.nalagbankend.domain.answer.service

import com.example.nalagbankend.domain.answer.domain.repository.AnswerRepository
import com.example.nalagbankend.domain.answer.presentation.dto.AnswersElement
import com.example.nalagbankend.domain.answer.presentation.dto.ChoiceElement
import com.example.nalagbankend.domain.answer.presentation.dto.QueryAnswersResponse
import com.example.nalagbankend.domain.quiz.domain.repository.ChoiceRepository
import com.example.nalagbankend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryAnswersService(
    private val answerRepository: AnswerRepository,
    private val choiceRepository: ChoiceRepository
) {
    @Transactional(readOnly = true)
    fun execute(): QueryAnswersResponse {
        val answers = answerRepository.findAll()
        return QueryAnswersResponse(
            answers.map { answer ->
                val choices = choiceRepository.findAllByQuiz(answer.quiz)
                AnswersElement(answer.id, answer.user.name, answer.quiz.title,
                    choices.map {
                        ChoiceElement(
                            it.content,
                            it.photo,
                            it == answer.choice
                        )
                    }
                )
            }
        )
    }
}