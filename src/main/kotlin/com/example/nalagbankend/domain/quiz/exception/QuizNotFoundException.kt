package com.example.nalagbankend.domain.quiz.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.QUIZ_NOT_FOUND
import com.example.nalagbankend.global.error.exception.NalagException

object QuizNotFoundException : NalagException(QUIZ_NOT_FOUND)