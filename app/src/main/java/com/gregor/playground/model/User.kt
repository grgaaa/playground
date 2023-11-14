package com.gregor.playground.model

data class User(
    val userId: Long?,
    val name: String
) : BaseModel()