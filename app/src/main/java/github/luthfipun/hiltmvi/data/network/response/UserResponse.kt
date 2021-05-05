package github.luthfipun.hiltmvi.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import github.luthfipun.hiltmvi.domain.model.User
import github.luthfipun.hiltmvi.data.network.model.UserDto

class UserResponse(
    @SerializedName("data")
    @Expose
    var data: List<UserDto>
) {
    fun toUserList(): List<UserDto> {
        return data
    }
}