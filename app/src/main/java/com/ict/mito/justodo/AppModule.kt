package com.ict.mito.justodo

import com.ict.mito.justodo.repository.ToDoInfoRepository
import com.ict.mito.justodo.repository.ToDoInfoRepositoryImpl
import com.ict.mito.justodo.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

/**
 * Created by mito on 2018/09/18.
 */
@Module
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun provideRepository(
            impl: ToDoInfoRepositoryImpl
    ): ToDoInfoRepository
    
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
