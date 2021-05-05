package github.luthfipun.hiltmvi.repository.remote

import github.luthfipun.hiltmvi.data.network.RemoteService
import github.luthfipun.hiltmvi.data.network.model.UserDto
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteService: RemoteService
) : RemoteRepository {
    override suspend fun getUser(): List<UserDto> {
        return remoteService.getUser().toUserList()
    }
}