package com.maxx.github_demo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface  Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: CacheEntity)

    @Query("SELECT * FROM blog")
    suspend fun get() : List<CacheEntity>



}