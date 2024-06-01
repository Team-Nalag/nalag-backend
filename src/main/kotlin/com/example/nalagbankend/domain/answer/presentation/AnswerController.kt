package com.example.nalagbankend.domain.answer.presentation

import com.example.nalagbankend.domain.answer.presentation.dto.QueryAnswersResponse
import com.example.nalagbankend.domain.answer.service.QueryAnswersService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/answers")
@RestController
class AnswerController(
    private val queryAnswersService: QueryAnswersService
) {
    @GetMapping()
    fun getAnswers(): QueryAnswersResponse = queryAnswersService.execute()
}