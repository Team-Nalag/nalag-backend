package com.example.nalagbankend.domain.user.presentation

import com.example.nalagbankend.domain.user.presentation.dto.TokenResponse
import com.example.nalagbankend.domain.user.service.GithubOAuthService
import com.example.nalagbankend.domain.user.service.GoogleOAuthService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    private val googleOAuthService: GoogleOAuthService,
    private val githubOAuthService: GithubOAuthService,
) {
    @GetMapping("/login/oauth2/code/google")
    fun googleLogin(@RequestParam("code") code: String): TokenResponse {
        return googleOAuthService.execute(code)
    }

    @GetMapping("/github")
    fun githubLogin(@RequestParam("code") code: String): TokenResponse {
        return githubOAuthService.execute(code)
    }
}