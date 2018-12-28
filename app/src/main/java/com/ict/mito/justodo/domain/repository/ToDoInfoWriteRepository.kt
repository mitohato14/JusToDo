package com.ict.mito.justodo.domain.repository

import com.ict.mito.justodo.domain.ToDoInfo
import io.reactivex.Completable

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoWriteRepository {
    suspend fun add(toDoInfo: ToDoInfo): Completable

    suspend fun remove(toDoInfo: ToDoInfo): Completable

    suspend fun remove(id: Long): Completable

    suspend fun store(toDoInfo: ToDoInfo): Completable
}
