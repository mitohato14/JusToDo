package com.ict.mito.justodo

import me.retty.reduxkt.StateType

data class ToDoState constructor(val todoInfoList: List<ToDoInfo> = emptyList()): StateType
