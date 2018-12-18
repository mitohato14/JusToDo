package com.ict.mito.justodo.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoInfo(
    @PrimaryKey(autoGenerate = true)
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
