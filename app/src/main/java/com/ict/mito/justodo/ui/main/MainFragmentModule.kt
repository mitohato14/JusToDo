package com.ict.mito.justodo.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mito on 2018/09/20.
 */
@Module
abstract class MainFragmentModule {
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment
}
