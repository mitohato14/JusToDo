package com.ict.mito.justodo.action

import com.github.rozag.redux.core.ReduxAction

/**
 * Created by mito on 2018/07/14.
 */
sealed class Action : ReduxAction {
    class AddToDo : Action()
    class EditToDo : Action()
    class DeleteToDo : Action()
    class CompleteToDo : Action()
    class UnCompleteToDo : Action()
}
