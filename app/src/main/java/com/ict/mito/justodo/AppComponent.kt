package com.ict.mito.justodo

import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by mito on 2018/09/18.
 */
@Singleton
@Component(
        modules = [
            AppModule::class,
            ActivityModule::class
        ]
)
interface AppComponent : AndroidInjector<App>
