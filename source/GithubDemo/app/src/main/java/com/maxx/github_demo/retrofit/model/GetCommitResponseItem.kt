package com.maxx.github_demo.retrofit.model


import com.google.gson.annotations.SerializedName

data class GetCommitResponseItem(
    @SerializedName("author")
    var author: Author,
    @SerializedName("comments_url")
    var commentsUrl: String,
    @SerializedName("commit")
    var commit: CommitX,
    @SerializedName("committer")
    var committer: CommitterX,
    @SerializedName("html_url")
    var htmlUrl: String,
    @SerializedName("node_id")
    var nodeId: String,
    @SerializedName("parents")
    var parents: List<Parent>,
    @SerializedName("sha")
    var sha: String,
    @SerializedName("url")
    var url: String
)