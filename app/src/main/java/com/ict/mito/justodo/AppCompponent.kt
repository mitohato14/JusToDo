package com.ict.mito.justodo

import com.ict.mito.justodo.ui.add.AddFragmentModule
import com.ict.mito.justodo.ui.main.MainFragmentModule
import dagger.BindsInstance
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
            AndroidInjectionModule::class,
            AppModule::class,
            MainFragmentModule::class,
            AddFragmentModule::class
        ]
)
interface AppCompponent : AndroidInjector<AppInjector> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App)
        fun build(): AppCompponent
    }
    fun inject(app: App)
}
