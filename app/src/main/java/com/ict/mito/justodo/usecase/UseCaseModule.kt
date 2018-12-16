package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.usecase.impl.AddToDoUseCaseImpl
import com.ict.mito.justodo.usecase.impl.DoneToDoUseCaseImpl
import com.ict.mito.justodo.usecase.impl.RemoveToDoUseCaseImpl
import com.ict.mito.justodo.usecase.impl.UnDoneToDoUseCaseImpl
import dagger.Binds
import dagger.Module

/**
 * Created by mito on 2018/10/03.
 */
@Module
abstract class UseCaseModule {
    @Binds
    abstract fun provideAddToDoUseCase(
        impl: AddToDoUseCaseImpl
    ): AddToDoUseCase

    @Binds
    abstract fun provideEditToDoUseCase(
        impl: RemoveToDoUseCaseImpl
    ): RemoveToDoUseCase

    @Binds
    abstract fun provideDoneToDoUseCase(
            impl: DoneToDoUseCaseImpl
    ): DoneToDoUseCase
    
    @Binds
    abstract fun provideUnDoneToDoUseCase(
            impl: UnDoneToDoUseCaseImpl
    ): UnDoneToDoUseCase
}