package com.ict.mito.justodo.infla.repository.impl

import androidx.annotation.WorkerThread
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.infla.db.dao.ToDoInfoDAO
import com.ict.mito.justodo.infla.repository.ToDoInfoRepository
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
    override suspend fun getAll(): List<ToDoInfo> = dao.getAllToDo()

    @WorkerThread
    override suspend fun getById(id: Long): ToDoInfo = dao.getToDoInfoById(id)

    @WorkerThread
    override suspend fun add(toDoInfo: ToDoInfo) = dao.insert(toDoInfo)

    @WorkerThread
    override suspend fun remove(toDoInfo: ToDoInfo) = dao.delete(toDoInfo)

    @WorkerThread
    override suspend fun remove(id: Long) = dao.delete(id)

    @WorkerThread
    override suspend fun store(toDoInfo: ToDoInfo) = dao.update(toDoInfo)

    @WorkerThread
    override suspend fun done(toDoInfo: ToDoInfo) {
        toDoInfo.done()
        dao.update(toDoInfo)
    }

    @WorkerThread
    override suspend fun undone(toDoInfo: ToDoInfo) {
        toDoInfo.undone()
        dao.update(toDoInfo)
    }
}
