package com.maxx.github_demo.retrofit.model


import com.google.gson.annotations.SerializedName

data class AuthorX(
    @SerializedName("date")
    var date: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("name")
    var name: String
)