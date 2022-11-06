package com.gregor.playground.repository

import com.gregor.playground.model.User
import io.reactivex.rxjava3.core.Single

interface IUserAccountRepository {

    fun login(userName: String, password: String): Single<User>
}