package com.ict.mito.justodo.domain.db

import dagger.Module
import dagger.Provides

/**
 * Created by mito on 2018-12-22.
 */
@Module
internal class DataBaseModule {
    @Provides
    internal fun provideDataBase() = ToDoRoomDataBase
}