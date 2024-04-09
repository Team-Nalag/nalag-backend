package com.example.nalagbankend.global.error

import com.example.nalagbankend.global.error.exception.NalagException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NalagException::class)
    fun customExceptionHandling(e: NalagException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse.of(e), HttpStatus.valueOf(e.status))
    }

    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): ResponseEntity<*>? {
        val errorMap: MutableMap<String, String?> = HashMap()
        for (error in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, HttpStatus.BAD_REQUEST)
    }
}