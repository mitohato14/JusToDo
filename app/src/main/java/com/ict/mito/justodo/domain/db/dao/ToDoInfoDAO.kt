package com.ict.mito.justodo.domain.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ict.mito.justodo.domain.ToDoInfo

/**
 * Created by mito on 2018-12-18.
 */
@Dao
interface ToDoInfoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createToDo(toDoInfo: ToDoInfo)
    
    @Query("SELECT * FROM ToDoInfo")
    fun findAll(): List<ToDoInfo>
    
    @Update
    fun updateToDoInfo(toDoInfoDAO: ToDoInfoDAO)
    
    @Delete
    fun deleteToDoInfo(toDoInfoDAO: ToDoInfoDAO)
}