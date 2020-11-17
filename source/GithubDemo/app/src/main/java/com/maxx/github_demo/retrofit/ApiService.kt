package com.maxx.github_demo.retrofit

import com.maxx.github_demo.retrofit.model.GetCommitResponse
import retrofit2.http.GET

interface ApiService {

    @GET("commits")
    suspend fun getAllCommits() : GetCommitResponse


}