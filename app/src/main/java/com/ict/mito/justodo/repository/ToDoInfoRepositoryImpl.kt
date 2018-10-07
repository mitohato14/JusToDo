package com.ict.mito.justodo.repository

import com.ict.mito.justodo.model.ToDoInfo
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by mito on 2018/09/18.
 */
class ToDoInfoRepositoryImpl : ToDoInfoRepository {
    private var todos: ArrayList<ToDoInfo> = arrayListOf()

    override fun getAll(): Single<List<ToDoInfo>> {
        TODO("Must implementation")
    }

    override fun getById(id: String): Maybe<ToDoInfo?> {
//        todos.find { it.id == id }
        TODO("Must implementation")
    }

    override fun saveAll(todos: ArrayList<ToDoInfo>): Completable{
        TODO("Must implementation")
    }

    override fun add(toDoInfo: ToDoInfo): Completable {
        TODO("Must implementation")
    }

    override fun remove(toDoInfo: ToDoInfo): Completable {
        TODO("Must implementation")
    }

    override fun remove(id: String): Completable {
        TODO("Must implementation")
    }
}
