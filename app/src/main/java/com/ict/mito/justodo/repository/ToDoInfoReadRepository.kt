package com.ict.mito.justodo.repository

import com.ict.mito.justodo.model.ToDoInfo

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoReadRepository {
    fun getAll(): List<ToDoInfo>

    fun getById(id: String): ToDoInfo
}
