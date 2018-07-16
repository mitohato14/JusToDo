package com.ict.mito.justodo.action

import com.ict.mito.justodo.model.ToDoInfo
import info.izumin.android.droidux.Action

/**
 * Created by mito on 2018/07/16.
 */
class CreateToDoAction(val toDoInfo: ToDoInfo) : Action
class EditToDoAction(val taskId: String) : Action
class UpdateToDoAction(
    val taskId: String,
    val toDoInfo: ToDoInfo
) : Action
class DeleteToDoAction(val taskId: String) : Action
class CompleteToDoAction(val taskId: String) : Action
