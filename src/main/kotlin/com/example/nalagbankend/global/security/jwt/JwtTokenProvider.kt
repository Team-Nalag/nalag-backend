package com.example.nalagbankend.global.security.jwt

import com.example.nalagbankend.domain.user.presentation.dto.TokenResponse
import com.example.nalagbankend.global.exception.TokenExpiredException
import com.example.nalagbankend.global.exception.TokenInvalidException
import com.example.nalagbankend.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.util.Date
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
) {
    fun generateToken(email: String): TokenResponse {
        val accessToken: String = createToken(email, "access", jwtProperties.accessExp)
        return TokenResponse(accessToken = accessToken)
    }

    private fun createToken(accountId: String, typ: String, exp: Long): String {
        return jwtProperties.prefix + Jwts.builder()
            .setSubject(accountId)
            .claim("typ", typ)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .setIssuedAt(Date())
            .compact()
    }

    fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getAccountId(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getAccountId(token: String): String {
        return getClaims(token).subject
    }

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw TokenExpiredException
        } catch (e: Exception) {
            e.printStackTrace()
            throw TokenInvalidException
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(jwtProperties.header)

        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.prefix)
            && bearerToken.length > jwtProperties.prefix.length + 1
        ) {
            bearerToken.substring(jwtProperties.prefix.length)
        } else null
    }
}