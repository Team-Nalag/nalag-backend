package com.example.nalagbankend.global.utils.openfeign.client.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.FEIGN_BAD_REQUEST
import com.example.nalagbankend.global.error.exception.NalagException


object FeignBadRequestException : NalagException(FEIGN_BAD_REQUEST)