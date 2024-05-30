package com.example.nalagbankend.global.utils.openfeign.client.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.FEIGN_UNAUTHORIZED
import com.example.nalagbankend.global.error.exception.NalagException

object FeignUnAuthorizedException : NalagException(FEIGN_UNAUTHORIZED)
