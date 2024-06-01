package com.example.nalagbankend.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),
    BAD_FILE_EXTENSION(400,"File Bad Extension"),
    SIZE_BAD_REQUEST(400, "Size Bad Request"),

    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),
    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden"),

    FEIGN_TOKEN_EXPIRED(419, "Feign Token Expired"),

    USER_NOT_FOUND(404, "User Not Found"),
    QUIZ_NOT_FOUND(404, "Quiz Not Found"),
    CHOICE_NOT_FOUND(404, "Choice Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}