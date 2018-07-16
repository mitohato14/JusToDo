package com.ict.mito.justodo.state

import com.ict.mito.justodo.model.ToDoInfo

/**
 * Created by mito on 2018/07/14.
 */
data class ToDoState(val toDoInfoList: List<ToDoInfo> = emptyList())