package com.ict.mito.justodo

import androidx.multidex.MultiDexApplication
import com.ict.mito.justodo.infla.db.DataBaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by mito on 2018/09/18.
 */
class App : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        DaggerAppComponent
            .builder()
            .dataBaseModule(DataBaseModule(applicationContext))
            .build()
            .inject(this)
        return androidInjector
    }
}
