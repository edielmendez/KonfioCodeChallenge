package mx.com.edieltech.konfiocodechallenge.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.com.edieltech.konfiocodechallenge.data.remote.constants.BASE_URL
import mx.com.edieltech.konfiocodechallenge.data.remote.network.NetworkApiClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        /*val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }*/
        return OkHttpClient
            .Builder()
            //.addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Singleton
    @Provides
    fun provideNetworkApiClient(retrofit: Retrofit): NetworkApiClient = retrofit.create(NetworkApiClient::class.java)
}