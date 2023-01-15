package com.gregor.playground.repository

import com.gregor.playground.model.User
import com.gregor.playground.repository.dto.RepoDTO

interface UserAccountRepository {

    fun login(userName: String, password: String): RepoDTO<User>
}