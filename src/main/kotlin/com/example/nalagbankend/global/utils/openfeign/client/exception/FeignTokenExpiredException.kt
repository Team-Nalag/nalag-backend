package com.example.nalagbankend.global.utils.openfeign.client.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.FEIGN_TOKEN_EXPIRED
import com.example.nalagbankend.global.error.exception.NalagException

object FeignTokenExpiredException : NalagException(FEIGN_TOKEN_EXPIRED)
