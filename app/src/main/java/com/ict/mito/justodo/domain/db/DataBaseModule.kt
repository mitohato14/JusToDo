package com.ict.mito.justodo.domain.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mito on 2018-12-22.
 */
@Module
internal class DataBaseModule(private val context: Context) {
    @Singleton
    @Provides
    internal fun provideDataBase() = Room.databaseBuilder(
            context,
            ToDoRoomDataBase::class.java,
            "justodo.db"
    )
            .allowMainThreadQueries()
            .build()
    
    @Provides
    internal fun provideDao(dataBase: ToDoRoomDataBase) = dataBase.todoInfoDao()
}