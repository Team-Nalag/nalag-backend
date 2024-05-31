package com.example.nalagbankend.domain.quiz.presentation.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateQuizRequest(
    @field:NotBlank(message = "title는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 30, message = "title는 30자 이하여야 합니다.")
    val title: String,
    val choice: List<ChoiceElement>
)

data class ChoiceElement(
    val content: String,
    val photo: String
)
