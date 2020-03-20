package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.DoneToDoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by mito on 2018-12-14.
 */
class DoneToDoUseCaseImpl @Inject constructor(
    private val repository: ToDoInfoRepository
) : DoneToDoUseCase {
    private var parentJob = Job()
    private val mainCoroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO
    private val scope = CoroutineScope(mainCoroutineContext)

    override fun execute(id: ToDoId) {
        scope.launch {
            repository.done(repository.getById(id.value.toLong()))
        }
    }
}
