package com.ict.mito.justodo.repository

import dagger.Binds
import dagger.Module

/**
 * Created by mito on 2018/09/18.
 */
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(
        impl: ToDoInfoRepositoryImpl
    ): ToDoInfoRepository
}
