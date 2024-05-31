package com.example.nalagbankend.domain.quiz.presentation.dto

data class CreateQuizRequest(
    val title: String,
    val choiceContent1: String,
    val choiceContent2: String,
    val choiceContent3: String,
    val choiceContent4: String,
    val choicePhoto1: String,
    val choicePhoto2: String,
    val choicePhoto3: String,
    val choicePhoto4: String,
)
