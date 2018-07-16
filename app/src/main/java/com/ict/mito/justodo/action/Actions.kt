package com.ict.mito.justodo.action

import com.ict.mito.justodo.model.ToDoInfo
import info.izumin.android.droidux.Action

/**
 * Created by mito on 2018/07/16.
 */
class CreateToDoInfo(val toDoInfo: ToDoInfo) : Action
class EditToDoInfo(val taskId: String) : Action
class UpdateToDoInfo(
    val taskId: String,
    val toDoInfo: ToDoInfo
) : Action
class DeleteToDoInfo(val taskId: String) : Action
