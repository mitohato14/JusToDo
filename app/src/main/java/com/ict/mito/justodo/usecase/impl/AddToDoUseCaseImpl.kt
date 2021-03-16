package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.infla.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.AddToDoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by mito on 2018/10/03.
 */
class AddToDoUseCaseImpl @Inject constructor(
    private val repository: ToDoInfoRepository
) : AddToDoUseCase {
    private var parentJob = Job()
    private val mainCoroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO
    private val scope = CoroutineScope(mainCoroutineContext)

    override fun execute(todo: ToDoInfo) = scope.launch {
        repository.add(todo)
    }
}
