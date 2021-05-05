package github.luthfipun.hiltmvi.repository

import github.luthfipun.hiltmvi.domain.model.User
import github.luthfipun.hiltmvi.domain.util.DataState
import github.luthfipun.hiltmvi.repository.local.LocalRepository
import github.luthfipun.hiltmvi.repository.remote.RemoteRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : MainRepository {

    override suspend fun getUser(): Flow<DataState<List<User>>> = flow {
        emit(DataState.Loading)
        delay(2000) // for testing only

        try {
            val getUser = remoteRepository.getUser()
            emit(DataState.Success(getUser.map { it.toUser() }))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}