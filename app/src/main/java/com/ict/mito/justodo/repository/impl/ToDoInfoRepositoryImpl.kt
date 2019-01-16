package com.ict.mito.justodo.repository.impl

import androidx.annotation.WorkerThread
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

    @WorkerThread
    override suspend fun getAll(): Single<LiveData<List<ToDoInfo>>> = dao.getAllToDo()

    override fun getById(id: Long): Maybe<ToDoInfo?> = Maybe.create {
        dao.getAllToDo().map { todoLiveData ->
            todoLiveData.value?.find {
                todo -> id == todo.id
            }
        }
    }

    @WorkerThread
    override suspend fun add(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                dao.insert(toDoInfo)
            }

    @WorkerThread
    override suspend fun remove(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                dao.delete(toDoInfo)
            }

    @WorkerThread
    override suspend fun remove(id: Long): Completable =
            Completable.create {
                getById(id).map { todo ->
                    dao.delete(todo)
                }
            }

    @WorkerThread
    override suspend fun store(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                dao.update(toDoInfo)
            }

    @WorkerThread
    override suspend fun done(id: Long): Completable =
            Completable.create {
                getById(id).map { toDoInfo ->
                    toDoInfo.done()
                    dao.update(toDoInfo)
                }
            }

    @WorkerThread
    override suspend fun done(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                toDoInfo.done()
                dao.update(toDoInfo)
            }

    @WorkerThread
    override suspend fun undone(id: Long): Completable =
            Completable.create {
                getById(id).map { toDoInfo ->
                    toDoInfo.undone()
                    dao.update(toDoInfo)
                }
            }

    @WorkerThread
    override suspend fun undone(toDoInfo: ToDoInfo): Completable =
            Completable.create {
                toDoInfo.undone()
                dao.update(toDoInfo)
            }
}
