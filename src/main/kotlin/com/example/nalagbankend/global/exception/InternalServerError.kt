package com.example.nalagbankend.global.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.INTERNAL_SERVER_ERROR
import com.example.nalagbankend.global.error.exception.NalagException

object InternalServerError : NalagException(INTERNAL_SERVER_ERROR)