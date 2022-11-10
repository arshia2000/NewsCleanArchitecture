package com.example.clean_digicala

import android.app.Application
import com.example.clean_digicala.bingsearch.di.BingNewsInjector
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationGlobal: Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin{
          androidLogger(Level.ERROR)
              .androidContext(this@ApplicationGlobal)
              .modules(BingNewsInjector.provideDependency())

        }
    }





}