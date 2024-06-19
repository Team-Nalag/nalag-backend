package com.example.nalagbankend.domain.answer.presentation.dto

import java.util.UUID

data class QueryAnswersResponse(
    val answers: List<AnswersElement>
)

data class AnswersElement(
    val id: UUID,
    val username: String,
    val title: String,
    val choices: List<ChoiceElement>
)
