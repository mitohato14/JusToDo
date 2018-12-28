package com.ict.mito.justodo.repository.impl

import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.db.dao.ToDoInfoDAO
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
class ToDoInfoRepositoryImpl @Inject constructor(
        private val dao: ToDoInfoDAO
) : ToDoInfoRepository {
    private var todos: ArrayList<ToDoInfo> = arrayListOf()

    override fun getAll(): Single<ArrayList<ToDoInfo>> = Single.just(todos)

    override fun getById(id: Long): Maybe<ToDoInfo?> =
            Maybe.create { todos.find { todo -> id == todo.id } }

    override fun add(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                todos.add(toDoInfo)
            }

    override fun remove(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                todos.remove(toDoInfo)
            }

    override fun remove(id: Long): Completable =
            Completable.create {
                getById(id).map { todo ->
                    todos.remove(todo)
                }
            }

    override fun store(toDoInfo: ToDoInfo): Single<ToDoInfo> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
