package github.luthfipun.hiltmvi.data.network

import github.luthfipun.hiltmvi.data.network.response.UserResponse
import retrofit2.http.GET

interface RemoteService {
    @GET("users")
    suspend fun getUser(): UserResponse
}