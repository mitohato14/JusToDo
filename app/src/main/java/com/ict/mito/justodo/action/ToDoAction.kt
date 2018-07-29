package com.ict.mito.justodo.action

import com.github.rozag.redux.core.ReduxAction

/**
 * Created by mito on 2018/07/14.
 */
sealed class ToDoAction : ReduxAction {
    class AddToDo : ToDoAction()
    class EditToDo : ToDoAction()
    class DeleteToDo : ToDoAction()
    class CompleteToDo : ToDoAction()
    class UnCompleteToDo : ToDoAction()
}
