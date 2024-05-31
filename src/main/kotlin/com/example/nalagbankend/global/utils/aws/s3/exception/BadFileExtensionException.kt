package com.example.nalagbankend.global.utils.aws.s3.exception

import com.example.nalagbankend.global.error.exception.ErrorCode.BAD_FILE_EXTENSION
import com.example.nalagbankend.global.error.exception.NalagException

object BadFileExtensionException : NalagException(BAD_FILE_EXTENSION)