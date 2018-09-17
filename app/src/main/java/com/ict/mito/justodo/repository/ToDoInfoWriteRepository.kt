package com.ict.mito.justodo.repository

import com.ict.mito.justodo.model.ToDoInfo

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoWriteRepository {
    fun saveAll(todos: ArrayList<ToDoInfo>)

    fun add(toDoInfo: ToDoInfo)

    fun remove(toDoInfo: ToDoInfo)
    
    fun remove(id: String)
}
