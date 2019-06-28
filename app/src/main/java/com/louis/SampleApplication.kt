package com.louis

import androidx.multidex.MultiDexApplication
import com.louis.di.appModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SampleApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        //DI
        startKoin {
            androidContext(this@SampleApplication)
            modules(appModel)
        }

    }
}