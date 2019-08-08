package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.UnDoneToDoUseCase
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by mito on 2018-12-14.
 */
class UnDoneToDoUseCaseImpl @Inject constructor(
    repository: ToDoInfoRepository
) : UnDoneToDoUseCase {
    override fun execute(id: ToDoId): Completable {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}