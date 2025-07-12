package mx.com.edieltech.konfiocodechallenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.com.edieltech.konfiocodechallenge.data.local.datasource.DogLocalDataSourceImpl
import mx.com.edieltech.konfiocodechallenge.data.remote.datasource.DogRemoteDataSourceImpl
import mx.com.edieltech.konfiocodechallenge.data.repository.DogRepositoryImpl
import mx.com.edieltech.konfiocodechallenge.domain.datasource.DogLocalDataSource
import mx.com.edieltech.konfiocodechallenge.domain.datasource.DogRemoteDataSource
import mx.com.edieltech.konfiocodechallenge.domain.repository.DogRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DogModule {
    @Provides
    @Singleton
    fun provideDogRepository(
        impl: DogRepositoryImpl
    ): DogRepository = impl

    @Provides
    @Singleton
    fun provideDogLocalDataSource(
        impl: DogLocalDataSourceImpl
    ): DogLocalDataSource = impl

    @Provides
    @Singleton
    fun provideDogRemoteDataSource(
        impl: DogRemoteDataSourceImpl
    ): DogRemoteDataSource = impl
}