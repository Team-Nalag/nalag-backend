package com.example.nalagbankend.global.utils.openfeign

import com.example.nalagbankend.global.exception.InternalServerError
import com.example.nalagbankend.global.utils.openfeign.client.exception.FeignBadRequestException
import com.example.nalagbankend.global.utils.openfeign.client.exception.FeignForbiddenException
import com.example.nalagbankend.global.utils.openfeign.client.exception.FeignTokenExpiredException
import com.example.nalagbankend.global.utils.openfeign.client.exception.FeignUnAuthorizedException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignClientErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() >= 400) {
            when (response.status()) {
                400 -> throw FeignBadRequestException
                401 -> throw FeignUnAuthorizedException
                403 -> throw FeignForbiddenException
                419 -> throw FeignTokenExpiredException
                else -> throw InternalServerError
            }
        }

        return FeignException.errorStatus(methodKey, response)
    }
}