package com.gregor.playground.network

import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okio.Buffer
import timber.log.Timber


class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Timber.d("outgoing request sent to ${request.url()}; body: ${requestBodyToString(request.body())}")
        return chain.proceed(request)
    }

    private fun requestBodyToString(requestBody: RequestBody?): String? {
        val buffer = Buffer()
        requestBody?.writeTo(buffer)
        return buffer.readUtf8()
    }
}