package com.ict.mito.justodo.model

data class ToDoInfo(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val dueData: String = "",
    val deadline: String = "",
    val completed: Boolean = false
)
