package com.ict.mito.justodo.domain.repository

import com.ict.mito.justodo.domain.ToDoInfo
import io.reactivex.Completable

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoWriteRepository {
    fun saveAll(todos: ArrayList<ToDoInfo>): Completable

    fun add(toDoInfo: ToDoInfo): Completable

    fun remove(toDoInfo: ToDoInfo): Completable

    fun remove(id: String): Completable
}
