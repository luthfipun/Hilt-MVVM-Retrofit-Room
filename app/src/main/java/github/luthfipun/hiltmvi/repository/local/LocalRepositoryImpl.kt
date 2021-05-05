package github.luthfipun.hiltmvi.repository.local

import github.luthfipun.hiltmvi.data.database.AppDatabase
import github.luthfipun.hiltmvi.data.database.model.UserCache
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : LocalRepository {
    override suspend fun getUser(): List<UserCache> {
        return appDatabase.UserDao().get()
    }

    override suspend fun saveUser(userCache: UserCache) {
        appDatabase.UserDao().insert(userCache)
    }
}