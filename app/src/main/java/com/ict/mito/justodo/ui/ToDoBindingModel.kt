package com.ict.mito.justodo.ui

import java.sql.Date

/**
 * Created by mito on 2018/10/12.
 */
data class ToDoBindingModel(
    val title: String,
    val date: Date?,
    val description: String
) {
    var clickable: Boolean = false
        get() = date != null
}
