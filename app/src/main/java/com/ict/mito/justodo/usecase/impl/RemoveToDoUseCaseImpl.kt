package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.infla.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.RemoveToDoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by mito on 2018/10/03.
 */
class RemoveToDoUseCaseImpl @Inject constructor(
    private val repository: ToDoInfoRepository
) : RemoveToDoUseCase {
    private var parentJob = Job()
    private val mainCoroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO
    private val scope = CoroutineScope(mainCoroutineContext)

    override fun execute(id: Long) = scope.launch {
        repository.remove(id)
    }
}
