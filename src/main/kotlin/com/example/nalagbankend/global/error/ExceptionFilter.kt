package com.example.nalagbankend.global.error

import com.example.nalagbankend.global.error.exception.NalagException
import com.example.nalagbankend.global.exception.InternalServerError
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExceptionFilter(
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (exception: Exception) {
            exception.printStackTrace()
            when (exception) {
                is NalagException -> writeErrorCode(exception, response)
                else -> writeErrorCode(InternalServerError, response)
            }
        }
    }

    private fun writeErrorCode(exception: NalagException, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(exception)
        response.apply {
            status = errorResponse.status
            characterEncoding = StandardCharsets.UTF_8.name()
            contentType = MediaType.APPLICATION_JSON_VALUE
            writer.write(objectMapper.writeValueAsString(errorResponse))
        }
    }
}