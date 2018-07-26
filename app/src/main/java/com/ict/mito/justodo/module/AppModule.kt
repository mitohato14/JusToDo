package com.ict.mito.justodo.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mito on 2018/07/26.
 */
@Module
class AppModule {
    private lateinit var app: App

    fun setApp(app: App) {
        this.app = app
    }

    @Provides
    @Singleton
    fun provideToDoStore() {
        app.getStore()
    }
}
