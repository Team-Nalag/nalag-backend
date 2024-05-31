package com.example.nalagbankend.domain.quiz.domain

import com.example.nalagbankend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_choice")
class Choice(
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val content: String,
    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val photo: String,
    quiz: Quiz
) : BaseUUIDEntity() {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "quiz_id", columnDefinition = "BINARY(16)", nullable = false)
    var quiz = quiz
        protected set
}