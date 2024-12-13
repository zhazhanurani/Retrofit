package com.example.konekin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Users(
    @SerializedName("id")
    val id : Int,
    @SerializedName("email")
    val email : String,
    @SerializedName("first_name")
    val firstName : String,
    @SerializedName("last_name")
    val last_name : String,
    @SerializedName("avatar")
    val avatar : String
) : Parcelable
