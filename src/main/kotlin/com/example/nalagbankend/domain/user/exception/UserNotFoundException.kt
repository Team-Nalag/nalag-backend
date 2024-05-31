package com.example.nalagbankend.domain.user.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.USER_NOT_FOUND
import com.example.nalagbankend.global.error.exception.NalagException

object UserNotFoundException: NalagException(USER_NOT_FOUND) {
}