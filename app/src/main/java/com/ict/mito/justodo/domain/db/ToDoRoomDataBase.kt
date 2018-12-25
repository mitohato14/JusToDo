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
@Database(entities = [ToDoInfo::class], version = 1)
abstract class ToDoRoomDataBase : RoomDatabase() {
    abstract fun todoInfoDao(): ToDoInfoDAO
    
    companion object {
        @Volatile
        private var INSTANCE: ToDoRoomDataBase? = null
        
        fun getDataBase(context: Context): ToDoRoomDataBase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context,
                        ToDoRoomDataBase::class.java,
                        "todo_database"
                ).build()
                
                INSTANCE = instance
                return instance
            }
        }
    }
}