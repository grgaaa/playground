package com.gregor.playground.repository

import com.gregor.playground.model.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserAccountRepository @Inject constructor() : IUserAccountRepository {

    override fun login(userName: String, password: String): Single<User> {
        // TODO
        return Single.just(User("Kiki", "Piki123"))
    }
}