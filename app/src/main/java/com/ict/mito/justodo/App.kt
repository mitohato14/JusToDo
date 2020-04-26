package com.ict.mito.justodo

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.ict.mito.justodo.infla.db.DataBaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by mito on 2018/09/18.
 */
class App : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .dataBaseModule(DataBaseModule(applicationContext))
            .build()
            .inject(this)
    }
}
