package com.example.nalagbankend.domain.answer.domain

import com.example.nalagbankend.domain.quiz.domain.Choice
import com.example.nalagbankend.domain.quiz.domain.Quiz
import com.example.nalagbankend.domain.user.domain.User
import com.example.nalagbankend.global.entity.BaseUUIDEntity
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_answer")
class Answer(
    choice: Choice,
    user: User,
    quiz: Quiz
) : BaseUUIDEntity() {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected set

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var quiz = quiz
        protected set

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var choice = choice
        protected set
}