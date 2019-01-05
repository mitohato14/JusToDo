package com.ict.mito.justodo.domain.repository

import androidx.lifecycle.LiveData
import com.ict.mito.justodo.domain.ToDoInfo
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by mito on 2018/09/17.
 */
interface ToDoInfoReadRepository {
    suspend fun getAll(): Single<LiveData<List<ToDoInfo>>>

    fun getById(id: Long): Maybe<ToDoInfo?>
}
