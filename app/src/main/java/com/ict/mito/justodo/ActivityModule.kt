package com.ict.mito.justodo

import com.ict.mito.justodo.ui.main.MainActivity
import com.ict.mito.justodo.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mito on 2018/09/21.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(
            modules = [
                MainActivityModule::class
            ]
    
    )
    abstract fun mainActivity(): MainActivity
}
