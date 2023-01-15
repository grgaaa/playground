package com.gregor.playground.repository

import com.gregor.playground.exceptions.RepositoryException
import com.gregor.playground.model.User
import com.gregor.playground.repository.dto.RepoDTO
import com.gregor.playground.service.NetworkService

import javax.inject.Inject

class UserAccountRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : UserAccountRepository {

    override fun login(userName: String, password: String): RepoDTO<User> {
        val userResponse = networkService.login(userName, password).execute()

        return if (userResponse.isSuccessful) {
            RepoDTO(userResponse.body()!!)
        } else {
            RepoDTO(null, true, RepositoryException(RepositoryException.LOGIN_ERROR))
        }
    }
}