package com.example.nalagbankend.domain.answer.presentation.dto

data class QueryAnswerDetailResponse(
    val username: String,
    val title: String,
    val choices: List<ChoiceElement>
)

data class ChoiceElement(
    val content: String,
    val photo: String,
    val isAnswer: Boolean
)
