package com.ict.mito.justodo.action

import com.ict.mito.justodo.model.ToDoInfo
import me.retty.reduxkt.Action

interface ToDoAction : Action {

    data class OnCreateToDoAction(val toDoInfo: ToDoInfo) : ToDoAction

    data class OnEditToDoAction(val taskId: String) : ToDoAction

    data class OnUpdateToDoAction(
        val taskId: String,
        val index: Int,
        val toDoInfo: ToDoInfo
    ) : ToDoAction
}
