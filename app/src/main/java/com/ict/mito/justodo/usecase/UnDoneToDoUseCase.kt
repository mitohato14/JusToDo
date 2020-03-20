package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.domain.ToDoId

/**
 * Created by mito on 2018-12-13.
 */
interface UnDoneToDoUseCase {
    fun execute(id: ToDoId)
}
