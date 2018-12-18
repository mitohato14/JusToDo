package com.ict.mito.justodo.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ict.mito.justodo.domain.db.dao.ToDoInfoDAO

/**
 * Created by mito on 2018-12-18.
 */
@Database(entities = [ToDoInfoDAO::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun todoInfoDao(): ToDoInfoDAO
}