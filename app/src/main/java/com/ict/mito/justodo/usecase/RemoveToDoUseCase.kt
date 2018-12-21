package com.ict.mito.justodo.usecase

import io.reactivex.Completable

/**
 * Created by mito on 2018/10/02.
 */
interface RemoveToDoUseCase {
    fun execute(id: Long): Completable
}
