package com.maxx.github_demo.retrofit.model


import com.google.gson.annotations.SerializedName

data class Parent(
    @SerializedName("html_url")
    var htmlUrl: String,
    @SerializedName("sha")
    var sha: String,
    @SerializedName("url")
    var url: String
)