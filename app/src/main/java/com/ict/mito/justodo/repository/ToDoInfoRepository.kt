package com.ict.mito.justodo.repository

import com.ict.mito.justodo.model.ToDoInfo

/**
 * Created by mito on 2018/09/17.
 */
class ToDoInfoRepository : ToDoInfoReadRepository, ToDoInfoWriteRepository{
    override fun getAll(): List<ToDoInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun getById(id: String): ToDoInfo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun saveAll(todos: List<ToDoInfo>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun add(toDoInfo: ToDoInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun remove(toDoInfo: ToDoInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun remove(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
