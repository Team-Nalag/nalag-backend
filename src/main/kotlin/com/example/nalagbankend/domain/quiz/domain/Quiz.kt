package com.example.nalagbankend.domain.quiz.domain

import com.example.nalagbankend.domain.user.domain.User
import com.example.nalagbankend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_quiz")
class Quiz(
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val title: String,
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val choiceContent1: String,
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val choiceContent2: String,
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val choiceContent3: String,
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val choiceContent4: String,
    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val choicePhoto1: String,
    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val choicePhoto2: String,
    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val choicePhoto3: String,
    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val choicePhoto4: String,

    user: User
): BaseUUIDEntity() {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected set
}