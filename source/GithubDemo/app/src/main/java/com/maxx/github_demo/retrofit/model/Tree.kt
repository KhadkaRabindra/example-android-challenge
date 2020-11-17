package com.maxx.github_demo.retrofit.model


import com.google.gson.annotations.SerializedName

data class Tree(
    @SerializedName("sha")
    var sha: String,
    @SerializedName("url")
    var url: String
)