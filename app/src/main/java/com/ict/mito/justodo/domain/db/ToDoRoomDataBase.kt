package com.ict.mito.justodo.domain.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.db.dao.ToDoInfoDAO

/**
 * Created by mito on 2018-12-18.
 */
@Database(entities = [ToDoInfo::class], version = 1, exportSchema = false)
abstract class ToDoRoomDataBase : RoomDatabase() {
    abstract fun todoInfoDao(): ToDoInfoDAO

    companion object {
        @Volatile
        private var INSTANCE: ToDoRoomDataBase? = null

        fun getDataBase(context: Context): ToDoRoomDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoRoomDataBase::class.java,
                        "justodo_database_db"
                )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance
                instance
            }
        }
    }
}