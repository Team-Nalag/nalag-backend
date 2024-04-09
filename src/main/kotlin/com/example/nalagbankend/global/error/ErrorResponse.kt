package com.example.nalagbankend.global.error

import com.example.nalagbankend.global.error.exception.NalagException

class ErrorResponse(
        val status: Int,
        val message: String,
) {
    companion object {
        fun of(e: NalagException): ErrorResponse {
            return ErrorResponse(
                    status = e.status,
                    message = e.message
            )
        }
    }
}