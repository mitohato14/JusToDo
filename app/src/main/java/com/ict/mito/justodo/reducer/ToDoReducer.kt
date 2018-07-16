package com.ict.mito.justodo.reducer

import com.ict.mito.justodo.action.CreateToDoInfo
import com.ict.mito.justodo.action.DeleteToDoInfo
import com.ict.mito.justodo.model.ToDoInfo
import com.ict.mito.justodo.state.ToDoState
import info.izumin.android.droidux.annotation.Dispatchable
import info.izumin.android.droidux.annotation.Reducer

/**
 * Created by mito on 2018/07/16.
 */
@Reducer(ToDoState::class)
class ToDoReducer {

    @Dispatchable(CreateToDoInfo::class)
    fun create(
        state: ToDoState,
        toDoInfo: ToDoInfo
    ): ToDoState = ToDoState(state.toDoInfoList + toDoInfo)

    @Dispatchable(DeleteToDoInfo::class)
    fun delete(
        state: ToDoState,
        toDoInfo: ToDoInfo
    ): ToDoState = ToDoState(state.toDoInfoList - toDoInfo)
}