package github.luthfipun.hiltmvi.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import github.luthfipun.hiltmvi.data.database.model.UserCache

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userCache: UserCache): Long

    @Query("SELECT * FROM user")
    suspend fun get(): List<UserCache>
}