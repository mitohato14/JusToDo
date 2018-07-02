package com.ict.mito.justodo.action

import com.ict.mito.justodo.model.ToDoInfo
import me.retty.reduxkt.Action

interface ToDoAction : Action {

    class OnCreateToDoAction(val toDoInfo: ToDoInfo) : ToDoAction

    class OnEditToDoAction(val taskId: String) : ToDoAction

    class onUpdateToDoAction(
        val taskId: String,
        val toDoInfo: ToDoInfo
    )
}