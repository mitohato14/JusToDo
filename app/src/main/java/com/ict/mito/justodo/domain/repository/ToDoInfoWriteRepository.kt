package com.ict.mito.justodo.domain.repository

import com.ict.mito.justodo.domain.ToDoInfo
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoWriteRepository {

    fun add(toDoInfo: ToDoInfo): Completable

    fun remove(toDoInfo: ToDoInfo): Completable

    fun remove(id: Long): Completable

    fun store(toDoInfo: ToDoInfo): Single<ToDoInfo>
}
