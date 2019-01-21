package com.ict.mito.justodo.domain.repository

import com.ict.mito.justodo.domain.ToDoInfo

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoWriteRepository {
    suspend fun add(toDoInfo: ToDoInfo)

    suspend fun remove(toDoInfo: ToDoInfo)

    suspend fun remove(id: Long)

    suspend fun store(toDoInfo: ToDoInfo)

    suspend fun done(toDoInfo: ToDoInfo)

    suspend fun undone(toDoInfo: ToDoInfo)
}
