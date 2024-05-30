package com.example.nalagbankend.global.utils.openfeign.client.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.FEIGN_FORBIDDEN
import com.example.nalagbankend.global.error.exception.NalagException


object FeignForbiddenException : NalagException(FEIGN_FORBIDDEN)