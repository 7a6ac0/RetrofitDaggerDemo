package me.tabacowang.retrofitdaggerdemo

import android.app.Application
import me.tabacowang.retrofitdaggerdemo.di.AppComponent
import me.tabacowang.retrofitdaggerdemo.di.AppModule
import me.tabacowang.retrofitdaggerdemo.di.DaggerAppComponent

class MainApplication : Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}