package com.example.nalagbankend.domain.quiz.presentation

import com.example.nalagbankend.domain.quiz.presentation.dto.CreateQuizRequest
import com.example.nalagbankend.domain.quiz.presentation.dto.UploadPhotoResponse
import com.example.nalagbankend.domain.quiz.service.CreateQuizService
import com.example.nalagbankend.domain.quiz.service.UploadPhotoService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/quizzes")
@RestController
class QuizController(
    private val createQuizService: CreateQuizService,
    private val uploadPhotoService: UploadPhotoService
) {
    @ResponseStatus(CREATED)
    @PostMapping
    fun createQuiz(@RequestBody request: CreateQuizRequest) {
        createQuizService.execute(request)
    }

    @PostMapping("/upload")
    fun uploadPhoto(@RequestPart("file") file: MultipartFile): UploadPhotoResponse {
        return uploadPhotoService.execute(file)
    }
}