package com.gregor.playground.repository.dto

data class RepoDTO<T>(
    val data: T?,
    val isError: Boolean? = false,
    val throwable: Throwable? = null,
    val source: Source
)
enum class Source {
    DB, REMOTE_SERVICE
}
