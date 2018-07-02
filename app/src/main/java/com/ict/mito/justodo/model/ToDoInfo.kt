package com.ict.mito.justodo.model

data class ToDoInfo(
    val id: String,
    val title: String,
    val content: String,
    val dueData: Int,
    val deadline: Int
)