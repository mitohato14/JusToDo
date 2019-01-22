package com.ict.mito.justodo.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "justodo_todo_table")
data class ToDoInfo(
    var title: String = "",

    var description: String = "",

    @ColumnInfo(name = "due_date")
    var dueData: String = "",

    @ColumnInfo(name = "deadline_date")
    var deadlineDate: Long = -1L,

    var done: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    fun done() {
        done = true
    }
    fun undone() {
        done = true
    }
}
