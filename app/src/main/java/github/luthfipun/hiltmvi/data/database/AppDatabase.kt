package github.luthfipun.hiltmvi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import github.luthfipun.hiltmvi.data.database.dao.UserDao
import github.luthfipun.hiltmvi.data.database.model.UserCache

@Database(entities = [UserCache::class], version = 1)
abstract class AppDatabase(): RoomDatabase() {

    abstract fun UserDao(): UserDao

    companion object {
        const val DATABASE_NAME: String = "example_app_db"
    }
}