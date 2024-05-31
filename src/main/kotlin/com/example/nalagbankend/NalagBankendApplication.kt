package com.example.nalagbankend

import com.example.nalagbankend.global.security.jwt.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(JwtProperties::class)
@SpringBootApplication
class NalagBankendApplication

fun main(args: Array<String>) {
    runApplication<NalagBankendApplication>(*args)
}
