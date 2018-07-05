package me.tabacowang.retrofitdaggerdemo.di

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import me.tabacowang.retrofitdaggerdemo.MainApplication
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val mainApplication: MainApplication) {

    @Provides @Singleton fun provideApplicationContext(): Context = mainApplication

    @Provides @Singleton fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(createGsonConverter())
                .client(makeOkHttpClient())
                .build()
    }

    private fun makeOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder().apply {
            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original
                        .newBuilder()
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            })
            addInterceptor(interceptor)
        }.build()
    }

    private fun createGsonConverter(): GsonConverterFactory {
        val builder = GsonBuilder().serializeNulls()
        return GsonConverterFactory.create(builder.create())
    }
}