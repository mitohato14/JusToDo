package com.ict.mito.justodo.repository.impl

import androidx.lifecycle.LiveData
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
    private var todos: LiveData<List<ToDoInfo>> = dao.findAll()

    override fun getAll(): Single<List<ToDoInfo>> = Single.just(todos.value)

    override fun getById(id: Long): Maybe<ToDoInfo?> =
            Maybe.create { todos.value?.find { todo -> id == todo.id } }

    override fun add(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                dao.createToDo(toDoInfo)
            }

    override fun remove(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                dao.deleteToDoInfo(toDoInfo)
            }

    override fun remove(id: Long): Completable =
            Completable.create {
                getById(id).map { todo ->
                    dao.deleteToDoInfo(todo)
                }
            }

    override fun store(toDoInfo: ToDoInfo): Completable =
        Completable.create {
            dao.updateToDoInfo(toDoInfo)
        }
}
