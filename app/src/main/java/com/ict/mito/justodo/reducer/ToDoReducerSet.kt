package com.ict.mito.justodo.reducer

import com.ict.mito.justodo.action.ToDoAction
import com.ict.mito.justodo.state.ToDoState

class ToDoReducerSet {

    companion object {
        fun aggregatedReducer(action: ToDoAction, state: ToDoState) = when (action) {
            is ToDoAction.OnCreateToDoAction -> onCreateToDoAction(
                    action,
                    state
            )
            is ToDoAction.OnEditToDoAction -> onEditToDoAction(
                    action,
                    state
            )
            is ToDoAction.OnUpdateToDoAction -> onUpdateToDoAction(
                    action,
                    state
            )
            else -> state
        }

        private fun onCreateToDoAction(
            action: ToDoAction.OnCreateToDoAction,
            state: ToDoState
        ) = state.copy(todoInfoList = state.todoInfoList + action.toDoInfo)

        private fun onEditToDoAction(
            action: ToDoAction.OnEditToDoAction,
            state: ToDoState
        ) = state

        private fun onUpdateToDoAction(
            action: ToDoAction.OnUpdateToDoAction,
            state: ToDoState
        ) = state // TODO:ここでToDo編集後に情報が更新されたリストを渡す
    }
}
