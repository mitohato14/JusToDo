package com.ict.mito.justodo.state

import com.github.rozag.redux.core.ReduxState
import com.ict.mito.justodo.model.ToDoInfo
import io.reactivex.Observable

/**
 * Created by mito on 2018/07/14.
 */
data class ToDoState(val toDoInfoList: List<ToDoInfo>) : ReduxState {

    companion object {
        val INITIAL: ToDoState = ToDoState(emptyList())
    }

    fun getToDoById(id: String): ToDoInfo = Observable
            .fromIterable(toDoInfoList)
            .filter { id == it.id }
            .blockingFirst()
}
