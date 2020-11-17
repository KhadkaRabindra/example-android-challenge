package com.maxx.github_demo.repository

import com.maxx.github_demo.model.Commit
import com.maxx.github_demo.retrofit.ApiService
import com.maxx.github_demo.retrofit.NetworkMapper
import com.maxx.github_demo.room.Dao
import com.maxx.github_demo.room.CacheMapper
import com.maxx.github_demo.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val dao: Dao,
    private val ApiService: ApiService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getBlogs(): Flow<DataState<List<Commit>>> = flow {
        emit(DataState.Loading)
        try {
            val networkBlogs = ApiService.getAllCommits()
            val commitList = networkMapper.mapFromEntityList(networkBlogs)

            emit(DataState.Success(commitList))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}