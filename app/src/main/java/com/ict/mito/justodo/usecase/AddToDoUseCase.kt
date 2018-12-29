package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.domain.ToDoInfo
import kotlinx.coroutines.Job

/**
 * Created by mito on 2018/10/02.
 */
interface AddToDoUseCase {
    fun execute(todo: ToDoInfo): Job
}
