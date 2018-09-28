package com.ict.mito.justodo

import dagger.Module

/**
 * Created by mito on 2018/09/28.
 */
@Module(
        includes = [
            RepositoryModule::class
        ]
)
class AppModule
