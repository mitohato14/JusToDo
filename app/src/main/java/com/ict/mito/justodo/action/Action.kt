package com.ict.mito.justodo.action

/**
 * Created by mito on 2018/07/14.
 */
sealed class Action {
    class AddToDo : Action()
    class EditToDo : Action()
    class DeleteToDo : Action()
    class CompleteToDo: Action()
    class UnCompleteToDo : Action()
}
