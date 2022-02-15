package com.developers.jectpackcomposestructures.di

import android.content.Context
import com.developers.jectpackcomposestructures.common.Constants.BASE_URL
import com.developers.jectpackcomposestructures.data.remote.CoinPaprikaApi
import com.developers.jectpackcomposestructures.data.repository.CoinRepositoryImpl
import com.developers.jectpackcomposestructures.di.qualifiers.IOThread
import com.developers.jectpackcomposestructures.di.qualifiers.MainThread
import com.developers.jectpackcomposestructures.domain.repository.CoinRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context,
    ) = context

    @MainThread
    @Singleton
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @IOThread
    @Singleton
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val localHttpLoggingInterceptor = HttpLoggingInterceptor()
        localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return localHttpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    fun providesApiService(okHttpClient: OkHttpClient): CoinPaprikaApi =
        Retrofit.Builder()
            .run {
                baseUrl(BASE_URL)
                client(okHttpClient)
                addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                    .setLenient()
                    .create()))
                build()
            }.create(CoinPaprikaApi::class.java)


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}