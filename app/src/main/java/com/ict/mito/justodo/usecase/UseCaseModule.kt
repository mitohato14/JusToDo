package com.ict.mito.justodo.usecase

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
            impl: EditToDoUseCaseImpl
    ): EditToDoUseCase
}