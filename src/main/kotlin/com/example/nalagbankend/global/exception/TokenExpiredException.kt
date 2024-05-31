package com.example.nalagbankend.global.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.TOKEN_EXPIRED
import com.example.nalagbankend.global.error.exception.NalagException

object TokenExpiredException : NalagException(TOKEN_EXPIRED)