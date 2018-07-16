package com.ict.mito.justodo.reducer

import com.ict.mito.justodo.action.CompletedToDoAction
import com.ict.mito.justodo.action.CreateToDoAction
import com.ict.mito.justodo.action.DeleteToDoAction
import com.ict.mito.justodo.action.UpdateToDoAction
import com.ict.mito.justodo.state.ToDoState
import info.izumin.android.droidux.annotation.Dispatchable
import info.izumin.android.droidux.annotation.Reducer

/**
 * Created by mito on 2018/07/16.
 */
@Reducer(ToDoState::class)
class ToDoReducer {

    @Dispatchable(CreateToDoAction::class)
    fun create(
        state: ToDoState,
        action: CreateToDoAction
    ): ToDoState = ToDoState(state.toDoInfoList + action.toDoInfo)

    @Dispatchable(UpdateToDoAction::class)
    fun update(
        state: ToDoState,
        action: UpdateToDoAction
    ): ToDoState = ToDoState(state.toDoInfoList - state.getToDoById(action.taskId) + action.toDoInfo)

    @Dispatchable(DeleteToDoAction::class)
    fun delete(
        state: ToDoState,
        action: DeleteToDoAction
    ): ToDoState = ToDoState(state.toDoInfoList - state.getToDoById(action.taskId))

    @Dispatchable(CompletedToDoAction::class)
    fun completed(
        state: ToDoState,
        action: CompletedToDoAction
    ) : ToDoState {
        val completedToDoInfo = state.getToDoById(action.taskId).copy(completed = true)
        return ToDoState(state.toDoInfoList - state.getToDoById(action.taskId) + completedToDoInfo)
    }
}