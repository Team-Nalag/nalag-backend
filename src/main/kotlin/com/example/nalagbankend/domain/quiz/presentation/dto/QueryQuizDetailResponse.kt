package com.example.nalagbankend.domain.quiz.presentation.dto

import com.example.nalagbankend.domain.quiz.domain.Choice

data class QueryQuizDetailResponse(
    val title: String,
    val choices: List<Choice>
)