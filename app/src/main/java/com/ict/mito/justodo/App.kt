package com.ict.mito.justodo

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by mito on 2018/09/18.
 */
class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    
    override fun onCreate() {
        super.onCreate()
        
    }
    
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}
