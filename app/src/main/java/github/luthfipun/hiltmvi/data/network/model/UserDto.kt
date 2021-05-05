package github.luthfipun.hiltmvi.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import github.luthfipun.hiltmvi.domain.model.User

data class UserDto(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("first_name")
    @Expose
    var firstName: String,

    @SerializedName("last_name")
    @Expose
    var lastName: String,

    @SerializedName("avatar")
    @Expose
    var avatar: String
) {
    fun toUser(): User {
        return User(
            id, email, firstName, lastName, avatar
        )
    }
}