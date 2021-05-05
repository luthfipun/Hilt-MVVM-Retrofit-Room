package github.luthfipun.hiltmvi.repository

import github.luthfipun.hiltmvi.domain.model.User
import github.luthfipun.hiltmvi.domain.util.DataState
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getUser(): Flow<DataState<List<User>>>
}