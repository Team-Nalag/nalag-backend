package com.example.nalagbankend.domain.answer.presentation.dto

data class QueryAnswersResponse(
    val answers: List<AnswersElement>
)

data class AnswersElement(
    val username: String,
    val title: String
)
