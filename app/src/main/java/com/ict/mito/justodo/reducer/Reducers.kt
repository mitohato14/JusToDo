package com.ict.mito.justodo.reducer

import com.ict.mito.justodo.action.ToDoAction
import com.ict.mito.justodo.state.ToDoState

/**
 * Created by mito on 2018/07/29.
 */
fun rootReducers(
    state: ToDoState,
    action: ToDoAction
): ToDoState = when (action) {
    is ToDoAction.AddToDo -> addToDoReducer(
            state,
            action
    )

    is ToDoAction.UpdateToDo -> updateToDoReducer(
            state,
            action
    )

    is ToDoAction.DeleteToDo -> deleteToDoReducer(
            state,
            action
    )

    is ToDoAction.CompleteToDo -> completedToDoReducer(
            state,
            action
    )

    is ToDoAction.UnCompleteToDo -> unCompletedToDoReducer(
            state,
            action
    )
}

fun addToDoReducer(
    state: ToDoState,
    action: ToDoAction.AddToDo
): ToDoState = ToDoState(state.toDoInfoList + action.toDoInfo)

fun updateToDoReducer(
    state: ToDoState,
    action: ToDoAction.UpdateToDo
): ToDoState = ToDoState(state.toDoInfoList - state.getToDoById(action.taskId) + action.toDoInfo)

fun deleteToDoReducer(
    state: ToDoState,
    action: ToDoAction.DeleteToDo
): ToDoState = ToDoState(state.toDoInfoList - state.getToDoById(action.taskId))

fun completedToDoReducer(
    state: ToDoState,
    action: ToDoAction.CompleteToDo
): ToDoState {
    val toDoInfo = state.getToDoById(action.taskId).copy(completed = true)
    return ToDoState(state.toDoInfoList - state.getToDoById(action.taskId) + toDoInfo)
}

fun unCompletedToDoReducer(
    state: ToDoState,
    action: ToDoAction.UnCompleteToDo
): ToDoState {
    val toDoInfo = state.getToDoById(action.taskId).copy(completed = false)
    return ToDoState(state.toDoInfoList - state.getToDoById(action.taskId) + toDoInfo)
}
