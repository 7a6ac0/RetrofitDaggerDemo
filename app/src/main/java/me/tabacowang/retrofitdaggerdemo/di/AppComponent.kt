package me.tabacowang.retrofitdaggerdemo.di

import dagger.Component
import me.tabacowang.retrofitdaggerdemo.MainActivity
import me.tabacowang.retrofitdaggerdemo.MainApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainApplication: MainApplication)
    fun inject(mainActivity: MainActivity)
}