package com.ict.mito.justodo.domain.repository

import com.ict.mito.justodo.domain.ToDoInfo

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoReadRepository {
    suspend fun getAll(): List<ToDoInfo>

    suspend fun getById(id: Long): ToDoInfo
}
