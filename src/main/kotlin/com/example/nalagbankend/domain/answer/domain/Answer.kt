package com.example.nalagbankend.domain.answer.domain

import com.example.nalagbankend.domain.quiz.domain.Quiz
import com.example.nalagbankend.domain.user.domain.User
import com.example.nalagbankend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "tbl_answer")
class Answer(
    @Column(columnDefinition = "CHAR(50)", nullable = false)
    val choice: String,
    user: User,
    quiz: Quiz
): BaseUUIDEntity()