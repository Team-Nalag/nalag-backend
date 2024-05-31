package com.example.nalagbankend.domain.quiz.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.SIZE_BAD_REQUEST
import com.example.nalagbankend.global.error.exception.NalagException

object SizeBadRequestException: NalagException(SIZE_BAD_REQUEST)