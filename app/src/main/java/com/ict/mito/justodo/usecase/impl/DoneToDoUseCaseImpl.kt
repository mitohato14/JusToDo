package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.DoneToDoUseCase
import io.reactivex.Completable
import io.reactivex.rxkotlin.subscribeBy
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

    override fun execute(id: ToDoId): Completable {
        return Completable.create { emitter ->
            repository.getById(id.value.toLong()).subscribeBy(
                onSuccess = {
                    scope.launch {
                        repository.done(it)
                        emitter.onComplete()
                    }
                }, onError = {
                    emitter.onError(it)
                }
            )
        }
    }
}
