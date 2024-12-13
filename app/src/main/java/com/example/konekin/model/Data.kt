package com.example.konekin.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("page")
    val page : Int,
    @SerializedName("per_page")
    val per_page : Int,
    @SerializedName("total")
    val total : Int,
    @SerializedName("total_pages")
    val total_page : Int,
    @SerializedName("data")
    val data : List<Users>
)
