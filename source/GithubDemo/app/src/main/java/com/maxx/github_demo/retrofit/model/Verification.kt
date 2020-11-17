package com.maxx.github_demo.retrofit.model


import com.google.gson.annotations.SerializedName

data class Verification(
    @SerializedName("payload")
    var payload: Any,
    @SerializedName("reason")
    var reason: String,
    @SerializedName("signature")
    var signature: Any,
    @SerializedName("verified")
    var verified: Boolean
)