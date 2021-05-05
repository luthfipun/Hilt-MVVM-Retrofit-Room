package github.luthfipun.hiltmvi.repository.local

import github.luthfipun.hiltmvi.data.database.model.UserCache

interface LocalRepository {
    suspend fun saveUser(userCache: UserCache)
    suspend fun getUser(): List<UserCache>
}