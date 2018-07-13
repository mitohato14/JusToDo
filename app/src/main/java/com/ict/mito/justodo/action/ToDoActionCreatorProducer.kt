package com.ict.mito.justodo.action

import com.ict.mito.justodo.AsyncActionCreator
import com.ict.mito.justodo.model.ToDoInfo

class ToDoActionCreatorProducer {

    companion object {
        fun produceCreateToDoAction(toDoInfo: ToDoInfo): AsyncActionCreator = { _, _, callback ->
            callback { _, _ ->
                ToDoAction.OnCreateToDoAction(toDoInfo)
            }
        }

//        fun produceCreateToDoAction(toDoInfo: ToDoInfo) : ActionCreator = { _, _ ->
//             ToDoAction.OnCreateToDoAction(toDoInfo)
//        }

        fun produceEditToDoAction(taskId: String): AsyncActionCreator = { _, _, callback ->
            callback { _, _ ->
                ToDoAction.OnEditToDoAction(taskId)
            }
        }

        fun produceUpdateToDoAction(
            taskId: String,
            index: Int,
            toDoInfo: ToDoInfo
        ): AsyncActionCreator = { _, _, callback ->
            callback { _, _ ->
                ToDoAction.OnUpdateToDoAction(
                        taskId,
                        index,
                        toDoInfo
                )
            }
        }
    }
}
