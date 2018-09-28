package com.ict.mito.justodo

import com.ict.mito.justodo.ui.add.AddFragmentModule
import com.ict.mito.justodo.ui.main.MainFragmentModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by mito on 2018/09/18.
 */
@Singleton
@Component(
        modules = [
            AppModule::class,
            RepositoryModule::class,
            MainFragmentModule::class,
            AddFragmentModule::class
        ]
)
interface AppComponent : AndroidInjector<App>
