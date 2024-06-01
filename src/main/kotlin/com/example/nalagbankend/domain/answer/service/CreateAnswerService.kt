package com.example.nalagbankend.domain.answer.service

import com.example.nalagbankend.domain.answer.domain.Answer
import com.example.nalagbankend.domain.answer.domain.repository.AnswerRepository
import com.example.nalagbankend.domain.quiz.domain.repository.ChoiceRepository
import com.example.nalagbankend.domain.quiz.domain.repository.QuizRepository
import com.example.nalagbankend.domain.quiz.exception.ChoiceNotFoundException
import com.example.nalagbankend.domain.quiz.exception.QuizNotFoundException
import com.example.nalagbankend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class CreateAnswerService(
    private val userFacade: UserFacade,
    private val quizRepository: QuizRepository,
    private val choiceRepository: ChoiceRepository,
    private val answerRepository: AnswerRepository
) {
    @Transactional
    fun execute(quizId: UUID, choiceId: UUID) {
        val user = userFacade.getCurrentUser()
        val quiz = quizRepository.findQuizById(quizId) ?: throw QuizNotFoundException
        val choice = choiceRepository.findChoiceById(choiceId) ?: throw ChoiceNotFoundException
        answerRepository.save(Answer(choice, user, quiz))
    }
}