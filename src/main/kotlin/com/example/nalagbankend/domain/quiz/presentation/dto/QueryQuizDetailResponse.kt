package com.example.nalagbankend.domain.quiz.presentation.dto

import java.util.UUID

data class QueryQuizDetailResponse(
    val title: String,
    val quizId: UUID,
    val choices: List<ChoiceElement>
)