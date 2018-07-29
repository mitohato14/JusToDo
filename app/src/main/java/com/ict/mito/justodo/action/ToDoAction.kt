package com.ict.mito.justodo.action

import com.github.rozag.redux.core.ReduxAction
import com.ict.mito.justodo.model.ToDoInfo

/**
 * Created by mito on 2018/07/14.
 */
sealed class ToDoAction : ReduxAction {
    class AddToDo(val toDoInfo: ToDoInfo) : ToDoAction()
    class UpdateToDo(
        val taskId: String,
        val toDoInfo: ToDoInfo
    ) : ToDoAction()
    class DeleteToDo(val taskId: String) : ToDoAction()
    class CompleteToDo(val taskId: String) : ToDoAction()
    class UnCompleteToDo(val taskId: String) : ToDoAction()
}
