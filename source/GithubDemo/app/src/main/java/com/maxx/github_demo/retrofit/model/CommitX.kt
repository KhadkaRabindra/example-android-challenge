package com.maxx.github_demo.retrofit.model


import com.google.gson.annotations.SerializedName

data class CommitX(
    @SerializedName("author")
    var author: AuthorX,
    @SerializedName("comment_count")
    var commentCount: Int,
    @SerializedName("committer")
    var committer: Committer,
    @SerializedName("message")
    var message: String,
    @SerializedName("tree")
    var tree: Tree,
    @SerializedName("url")
    var url: String,
    @SerializedName("verification")
    var verification: Verification
)