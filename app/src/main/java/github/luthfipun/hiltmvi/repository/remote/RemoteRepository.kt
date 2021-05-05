package github.luthfipun.hiltmvi.repository.remote

import github.luthfipun.hiltmvi.data.network.model.UserDto

interface RemoteRepository {
    suspend fun getUser(): List<UserDto>
}