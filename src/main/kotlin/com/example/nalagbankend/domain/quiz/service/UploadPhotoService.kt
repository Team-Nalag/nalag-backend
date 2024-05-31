package com.example.nalagbankend.domain.quiz.service

import com.example.nalagbankend.domain.quiz.presentation.dto.UploadPhotoResponse
import com.example.nalagbankend.global.utils.aws.s3.S3Util
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class UploadPhotoService(
    private val s3Util: S3Util
) {
    @Transactional
    fun execute(file: MultipartFile): UploadPhotoResponse {
        return UploadPhotoResponse(s3Util.upload(file))
    }
}