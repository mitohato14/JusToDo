package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.infla.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.UnDoneToDoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by mito on 2018-12-14.
 */
class UnDoneToDoUseCaseImpl @Inject constructor(
    repository: ToDoInfoRepository
) : UnDoneToDoUseCase {
    private var parentJob = Job()
    private val mainCoroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO
    private val scope = CoroutineScope(mainCoroutineContext)
    override fun execute(id: ToDoId) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
