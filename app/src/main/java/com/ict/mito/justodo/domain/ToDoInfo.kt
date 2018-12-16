package com.ict.mito.justodo.domain

data class ToDoInfo(
    val id: ToDoId,
    var title: String,
    var description: String,
    val dueData: String,
    val deadline: String,
    private var done: Boolean
) {
    fun done() {
        done = true
    }
    fun undone() {
        done = true
    }
}
