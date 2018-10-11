package com.example.harit.architecturecompetitionexamples

import android.app.Application
import com.example.harit.architecturecompetitionexamples.data.di.AppComponent
import com.example.harit.architecturecompetitionexamples.data.di.AppModule
import com.example.harit.architecturecompetitionexamples.data.di.DaggerAppComponent
import com.example.harit.architecturecompetitionexamples.data.di.UserRepositoryModule
import com.facebook.stetho.Stetho

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .userRepositoryModule(UserRepositoryModule())
                .build()
    }

}