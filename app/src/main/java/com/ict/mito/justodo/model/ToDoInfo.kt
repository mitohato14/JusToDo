package com.ict.mito.justodo.model

data class ToDoInfo(
    val id: ToDoId,
    var title: String,
    var description: String,
    val dueData: String,
    val deadline: String,
    val completed: Boolean
)
