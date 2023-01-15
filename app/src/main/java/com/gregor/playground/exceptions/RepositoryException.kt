package com.gregor.playground.exceptions

class RepositoryException(
    val errorCode: Int,
    val exception: Exception? = null
) : Exception() {

    companion object ErrorCodes {
        val DB_ERROR = 1
        val NETWORK_ERROR = 2
        val LOGIN_ERROR = 3
    }
}