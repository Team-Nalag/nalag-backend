package com.example.nalagbankend.domain.answer.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.ANSWER_NOT_FOUND
import com.example.nalagbankend.global.error.exception.NalagException

object AnswerNotFoundException: NalagException(ANSWER_NOT_FOUND)