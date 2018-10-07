package com.ict.mito.justodo.repository

import com.ict.mito.justodo.repository.ToDoInfoRepository
import com.ict.mito.justodo.repository.ToDoInfoRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by mito on 2018/09/18.
 */
@Module
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideRepository(
        impl: ToDoInfoRepositoryImpl
    ): ToDoInfoRepository
}
