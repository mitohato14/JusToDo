package com.ict.mito.justodo.action

import com.ict.mito.justodo.model.ToDoInfo
import info.izumin.android.droidux.Action

/**
 * Created by mito on 2018/07/16.
 */
class CreateToDoInfo(toDoInfo: ToDoInfo) : Action
class EditToDoInfo(taskId: String) : Action
class UpdateToDoInfo(
        taskId: String,
        toDoInfo: ToDoInfo
) : Action
class DeleteToDoInfo(taskId: String) : Action
