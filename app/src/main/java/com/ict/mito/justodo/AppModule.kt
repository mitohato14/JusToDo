package com.ict.mito.justodo

import com.ict.mito.justodo.domain.db.DataBaseModule
import com.ict.mito.justodo.repository.RepositoryModule
import com.ict.mito.justodo.usecase.UseCaseModule
import dagger.Module

/**
 * Created by mito on 2018/09/28.
 */
@Module(
        includes = [
            RepositoryModule::class,
            UseCaseModule::class,
            DataBaseModule::class
        ]
)
class AppModule
