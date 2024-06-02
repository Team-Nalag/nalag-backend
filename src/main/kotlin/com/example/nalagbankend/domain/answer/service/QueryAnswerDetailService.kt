package com.example.nalagbankend.domain.answer.service

import com.example.nalagbankend.domain.answer.domain.repository.AnswerRepository
import com.example.nalagbankend.domain.answer.exception.AnswerNotFoundException
import com.example.nalagbankend.domain.answer.presentation.dto.ChoiceElement
import com.example.nalagbankend.domain.answer.presentation.dto.QueryAnswerDetailResponse
import com.example.nalagbankend.domain.quiz.domain.repository.ChoiceRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class QueryAnswerDetailService(
    private val answerRepository: AnswerRepository,
    private val choiceRepository: ChoiceRepository,
) {
    @Transactional(readOnly = true)
    fun execute(id: UUID): QueryAnswerDetailResponse {
        val answer = answerRepository.findAnswerById(id) ?: throw AnswerNotFoundException
        val choices = choiceRepository.findAllByQuiz(answer.quiz)

        return QueryAnswerDetailResponse(
            answer.user.name,
            answer.quiz.title,
            choices.map {
                ChoiceElement(
                    it.content,
                    it.photo,
                    it == answer.choice
                )
            }
        )
    }
}