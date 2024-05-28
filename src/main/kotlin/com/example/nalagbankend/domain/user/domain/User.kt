package com.example.nalagbankend.domain.user.domain

import com.example.nalagbankend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "tbl_user")
class User(
    @Column(columnDefinition = "CHAR(60)", nullable = false)
    val email: String,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    val name: String,

    @Column(columnDefinition = "VARCHAR(3000)", nullable = false)
    val profile: String
): BaseUUIDEntity()