package com.ict.mito.justodo.repository

import com.ict.mito.justodo.model.ToDoInfo

/**
 * Created by mito on 2018/09/17.
 */
class ToDoInfoRepository : ToDoInfoReadRepository, ToDoInfoWriteRepository {
    private var todos: ArrayList<ToDoInfo> = arrayListOf()

    override fun getAll(): List<ToDoInfo> {
        return todos
    }

    override fun getById(id: String): ToDoInfo? {
        return todos.find { it.id == id }
    }

    override fun saveAll(todos: ArrayList<ToDoInfo>) {
        this.todos = todos
    }

    override fun add(toDoInfo: ToDoInfo) {
        todos.add(toDoInfo)
    }

    override fun remove(toDoInfo: ToDoInfo) {
        todos.remove(toDoInfo)
    }

    override fun remove(id: String) {
        todos.forEach {
            if (it.id == id) {
                todos.remove(it)
            }
        }
    }
}
