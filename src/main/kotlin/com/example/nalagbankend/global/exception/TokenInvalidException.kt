package com.example.nalagbankend.global.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.TOKEN_INVALID
import com.example.nalagbankend.global.error.exception.NalagException

object TokenInvalidException : NalagException(TOKEN_INVALID)