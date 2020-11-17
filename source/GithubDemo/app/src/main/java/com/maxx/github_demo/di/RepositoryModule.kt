package com.maxx.github_demo.di

import com.maxx.github_demo.repository.MainRepository
import com.maxx.github_demo.retrofit.ApiService
import com.maxx.github_demo.retrofit.NetworkMapper
import com.maxx.github_demo.room.Dao
import com.maxx.github_demo.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(dao: Dao,
                              ApiService: ApiService,
                              cacheMapper: CacheMapper,
                              networkMapper: NetworkMapper
    ) : MainRepository{
        return MainRepository(dao, ApiService, cacheMapper, networkMapper)
    }
}