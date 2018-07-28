package com.ict.mito.justodo.module

import dagger.Component
import javax.inject.Singleton

/**
 * Created by mito on 2018/07/27.
 */
@Singleton
@Component(
        modules = [(AppModule::class)]
)
interface AppComponent {
//    var createMainActivityComponent(module: MainModule):
}
