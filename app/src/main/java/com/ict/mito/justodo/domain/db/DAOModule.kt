package com.ict.mito.justodo.domain.db

import com.ict.mito.justodo.domain.db.dao.ToDoInfoDAO
import dagger.Binds
import dagger.Module

/**
 * Created by mito on 2018-12-22.
 */
@Module
abstract class DAOModule {
    @Binds
    abstract fun provideDao(
            dao: ToDoInfoDAO
    ): ToDoInfoDAO
}