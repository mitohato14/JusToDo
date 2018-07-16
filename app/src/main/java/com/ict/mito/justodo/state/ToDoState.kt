package com.ict.mito.justodo.state

import com.ict.mito.justodo.model.ToDoInfo
import io.reactivex.Observable

/**
 * Created by mito on 2018/07/14.
 */
data class ToDoState(val toDoInfoList: List<ToDoInfo> = emptyList()) {

    fun getToDoById(id: String) = Observable
            .fromIterable(toDoInfoList)
            .filter { id == it.id }
            .blockingFirst()

}