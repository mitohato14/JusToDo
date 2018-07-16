package com.ict.mito.justodo.reducer

import com.ict.mito.justodo.action.CreateToDoInfo
import com.ict.mito.justodo.action.DeleteToDoInfo
import com.ict.mito.justodo.model.ToDoInfo
import com.ict.mito.justodo.state.State
import info.izumin.android.droidux.annotation.Dispatchable
import info.izumin.android.droidux.annotation.Reducer

/**
 * Created by mito on 2018/07/16.
 */
@Reducer(State::class)
class ToDoReducer {

    @Dispatchable(CreateToDoInfo::class)
    fun create(
        state: State,
        toDoInfo: ToDoInfo
    ): State = State(state.toDoInfoList + toDoInfo)

    @Dispatchable(DeleteToDoInfo::class)
    fun delete(
        state: State,
        toDoInfo: ToDoInfo
    ): State = State(state.toDoInfoList - toDoInfo)
}