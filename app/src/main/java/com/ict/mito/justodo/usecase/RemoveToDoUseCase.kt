package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.domain.ToDoId
import io.reactivex.Completable

/**
 * Created by mito on 2018/10/02.
 */
interface RemoveToDoUseCase {
    fun execute(id: ToDoId): Completable
}
