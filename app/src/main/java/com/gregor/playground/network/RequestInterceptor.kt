package com.gregor.playground.network

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Timber.d("outgoing request sent to ${request.url()}")
        return chain.proceed(request)
    }
}