package com.gregor.playground.di

import com.google.gson.GsonBuilder
import com.gregor.playground.network.RequestInterceptor
import com.gregor.playground.service.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService {
        val okHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(RequestInterceptor())
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://e68w4.wiremockapi.cloud/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(NetworkService::class.java)
    }
}