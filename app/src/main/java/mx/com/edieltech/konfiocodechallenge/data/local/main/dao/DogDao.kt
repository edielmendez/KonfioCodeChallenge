package mx.com.edieltech.konfiocodechallenge.data.local.main.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mx.com.edieltech.konfiocodechallenge.data.local.main.entities.DogEntity

@Dao
interface DogDao {
    @Query("SELECT * FROM dogs")
    fun getAll(): Flow<List<DogEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(dogList: List<DogEntity>)
}