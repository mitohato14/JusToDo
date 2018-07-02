package com.ict.mito.justodo.model

data class ToDoInfo(
    var name: String = "",
    var content: String = "",
    var dueData: Int = -1,
    var deadline: Int = 101
)