package com.ict.mito.justodo.model

data class ToDoInfo(
    val id: String = "",
    var title: String = "",
    var description: String = "",
    val dueData: String = "",
    val deadline: String = "",
    val completed: Boolean = false
)
