package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.CompleteToDoUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by mito on 2018-12-14.
 */
class CompleteToDoUseCaseImpl @Inject constructor(
        private val repository: ToDoInfoRepository
) : CompleteToDoUseCase {
    override fun execute(id: ToDoId): Single<ToDoInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}