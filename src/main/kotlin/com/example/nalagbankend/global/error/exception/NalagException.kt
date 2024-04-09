package com.example.nalagbankend.global.error.exception

import com.example.nalagbankend.global.error.exception.ErrorCode

abstract class NalagException(
        val errorCode: ErrorCode
) : RuntimeException() {
    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message
}