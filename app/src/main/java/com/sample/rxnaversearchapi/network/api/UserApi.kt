package com.sample.rxnaversearchapi.network.api

import com.sample.rxnaversearchapi.network.model.UserResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @POST("/v1/user/login")
    fun getUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<UserResponse>

}