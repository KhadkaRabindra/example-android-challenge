package com.maxx.github_demo.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CacheEntity::class], version = 1)
abstract class Database : RoomDatabase(){

    abstract fun blogDao() : Dao

    companion object{
        val DATABASE_NAME: String = "MyDB"
    }
}
