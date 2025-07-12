package mx.com.edieltech.konfiocodechallenge.data.local.main.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.com.edieltech.konfiocodechallenge.data.local.main.dao.DogDao
import mx.com.edieltech.konfiocodechallenge.data.local.main.entities.DogEntity

@Database(entities = [DogEntity::class], version = 1, exportSchema = false)
abstract class KonfioCodeChallengeDataBase: RoomDatabase() {
    abstract fun dogDao(): DogDao


    companion object {
    private const val DB_NAME = "KONFIO_CODE_CHALLENGE_APP_ROOM.db"

        // For Singleton instantiation
        @Volatile private var instance: KonfioCodeChallengeDataBase? = null

        fun getInstance(context: Context): KonfioCodeChallengeDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): KonfioCodeChallengeDataBase {
            return Room.databaseBuilder(context, KonfioCodeChallengeDataBase::class.java, DB_NAME)
                .build()
        }
    }
}