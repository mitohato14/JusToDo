package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.domain.ToDoId

/**
 * Created by mito on 2018-12-13.
 */
interface DoneToDoUseCase {
    fun execute(id: ToDoId)
}
