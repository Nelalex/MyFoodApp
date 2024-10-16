package com.nelalexxx.myfoodapp.di.modules

import com.nelalexxx.myfoodapp.data.repositories.MenuRepository
import com.nelalexxx.myfoodapp.data.repositories.MenuRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {
    @Provides
    fun provideMenuRepository(): MenuRepository {
        return MenuRepositoryImpl()
    }
}