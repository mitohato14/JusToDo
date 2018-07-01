package com.ict.mito.justodo.state

import com.ict.mito.justodo.model.ToDoInfo
import me.retty.reduxkt.StateType

data class ToDoState constructor(val todoInfoList: List<ToDoInfo> = emptyList()) : StateType
