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
    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    val title: String,
    user: User
): BaseUUIDEntity() {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected set
}