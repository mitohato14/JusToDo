package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.DoneToDoUseCase
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by mito on 2018-12-14.
 */
class DoneToDoUseCaseImpl @Inject constructor(
    private val repository: ToDoInfoRepository
) : DoneToDoUseCase {
    override fun execute(id: ToDoId): Completable {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}