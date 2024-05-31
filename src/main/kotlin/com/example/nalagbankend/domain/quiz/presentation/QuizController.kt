package com.example.nalagbankend.domain.quiz.presentation

import com.example.nalagbankend.domain.quiz.presentation.dto.CreateQuizRequest
import com.example.nalagbankend.domain.quiz.service.CreateQuizService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/quizzes")
@RestController
class QuizController(
    private val createQuizService: CreateQuizService
) {
    @ResponseStatus(CREATED)
    @PostMapping
    fun createQuiz(@RequestBody request: CreateQuizRequest) {
        createQuizService.execute(request)
    }
}