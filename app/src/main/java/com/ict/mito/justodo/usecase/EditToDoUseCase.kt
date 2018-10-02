package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.ToDoId
import io.reactivex.Completable

/**
 * Created by mito on 2018/10/02.
 */
interface EditToDoUseCase {
    fun execute(id: ToDoId): Completable
}
