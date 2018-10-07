package com.ict.mito.justodo.repository

import com.ict.mito.justodo.model.ToDoInfo
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoReadRepository {
    fun getAll(): Single<List<ToDoInfo>>

    fun getById(id: String): Maybe<ToDoInfo?>
}
