package com.ict.mito.justodo.domain.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.db.dao.ToDoInfoDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by mito on 2018-12-18.
 */
@Database(entities = [ToDoInfo::class], version = 1)
abstract class ToDoRoomDataBase : RoomDatabase() {
    abstract fun todoInfoDao(): ToDoInfoDAO

    companion object {
        @Volatile
        private var INSTANCE: ToDoRoomDataBase? = null

        fun getDataBase(
                context: Context,
                scope: CoroutineScope
        ): ToDoRoomDataBase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context,
                        ToDoRoomDataBase::class.java,
                        "justodo.db"
                )
                        .allowMainThreadQueries()
                        .addCallback(ToDoInfoDatabaseCallback(scope))
                        .build()

                INSTANCE = instance
                return instance
            }
        }
    }
    
    private class ToDoInfoDatabaseCallback(private val scope: CoroutineScope)
        : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch(Dispatchers.IO) {
                    populateDatabase(it.todoInfoDao())
                }
            }
        }

        fun populateDatabase(toDoInfoDAO: ToDoInfoDAO) {
//            データベースが作られるときの初期処理(多分)
        }
    }
}