package com.gregor.playground.service

import com.gregor.playground.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NetworkService {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("username") username: String, @Field("password") password: String): Call<User>

}