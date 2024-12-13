package com.example.konekin.network

import com.example.konekin.model.Data
import com.example.konekin.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users?page=2") // employee diganti users
    fun getAllUsers(): Call<Data>

}