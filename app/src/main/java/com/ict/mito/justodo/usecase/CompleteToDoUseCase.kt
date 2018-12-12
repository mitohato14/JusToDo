package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.domain.ToDoId
import io.reactivex.Completable

/**
 * Created by mito on 2018-12-13.
 */
interface CompleteToDoUseCase {
    fun execute(id: ToDoId): Completable
}