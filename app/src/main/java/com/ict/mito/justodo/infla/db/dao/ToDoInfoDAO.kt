package com.ict.mito.justodo.infla.db.dao

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
    suspend fun insert(toDoInfo: ToDoInfo)

    @Query("SELECT * FROM justodo_todo_table")
    suspend fun getAllToDo(): List<ToDoInfo>

    @Query("SELECT * FROM justodo_todo_table WHERE id = :todoId")
    suspend fun getToDoInfoById(todoId: Long): ToDoInfo

    @Update
    suspend fun update(toDoInfo: ToDoInfo)

    @Delete
    suspend fun delete(toDoInfo: ToDoInfo)

    @Query("DELETE FROM justodo_todo_table WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM justodo_todo_table")
    suspend fun deleteAll()
}
