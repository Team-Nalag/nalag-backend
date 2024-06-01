package com.example.nalagbankend.domain.quiz.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.CHOICE_NOT_FOUND
import com.example.nalagbankend.global.error.exception.NalagException

object ChoiceNotFoundException : NalagException(CHOICE_NOT_FOUND)