package com.ict.mito.justodo.repository.impl

import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mito on 2018/09/18.
 */
@Singleton
class ToDoInfoRepositoryImpl @Inject constructor() : ToDoInfoRepository {
    private var todos: ArrayList<ToDoInfo> = arrayListOf()

    override fun getAll(): Single<List<ToDoInfo>> {
        TODO("Must implementation")
    }

    override fun getById(id: ToDoId): Maybe<ToDoInfo?> {
//        todos.find { it.id == id }
        TODO("Must implementation")
    }

    override fun saveAll(todos: ArrayList<ToDoInfo>): Completable {
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
