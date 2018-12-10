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

    override fun getAll(): Single<List<ToDoInfo>> = Single.just(todos)

    override fun getById(id: ToDoId): Maybe<ToDoInfo?> =
            Maybe.create { todos.find { todo -> id == todo.id } }

    override fun saveAll(todos: ArrayList<ToDoInfo>): Completable =
            Completable.create {
                this.todos = todos
            }

    override fun add(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                todos.add(toDoInfo)
            }

    override fun remove(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                todos.remove(toDoInfo)
            }

    override fun remove(id: ToDoId): Completable =
            Completable.create {
                getById(id).map { todo ->
                    todos.remove(todo)
                }
            }
}
