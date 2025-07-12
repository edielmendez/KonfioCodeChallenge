package mx.com.edieltech.konfiocodechallenge.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mx.com.edieltech.konfiocodechallenge.data.local.main.dao.DogDao
import mx.com.edieltech.konfiocodechallenge.data.local.main.db.KonfioCodeChallengeDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideKonfioCodeChallengeDataBase(@ApplicationContext context: Context): KonfioCodeChallengeDataBase {
        return KonfioCodeChallengeDataBase.getInstance(context)
    }

    @Provides
    fun provideDogDao(appDatabase: KonfioCodeChallengeDataBase): DogDao {
        return appDatabase.dogDao()
    }
}