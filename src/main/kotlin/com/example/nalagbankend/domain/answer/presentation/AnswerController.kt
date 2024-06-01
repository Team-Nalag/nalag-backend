package com.example.nalagbankend.domain.answer.presentation

import com.example.nalagbankend.domain.answer.presentation.dto.QueryAnswersResponse
import com.example.nalagbankend.domain.answer.service.CreateAnswerService
import com.example.nalagbankend.domain.answer.service.QueryAnswersService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/answers")
@RestController
class AnswerController(
    private val queryAnswersService: QueryAnswersService,
    private val createAnswerService: CreateAnswerService
) {
    @GetMapping
    fun getAnswers(): QueryAnswersResponse = queryAnswersService.execute()

    @ResponseStatus(CREATED)
    @PostMapping("{quiz-id}/{choice-id}")
    fun createAnswer(@PathVariable("quiz-id") quizId: UUID, @PathVariable("choice-id") choiceId: UUID) =
        createAnswerService.execute(quizId, choiceId)
}