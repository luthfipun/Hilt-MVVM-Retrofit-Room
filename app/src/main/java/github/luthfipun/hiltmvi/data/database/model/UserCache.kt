package github.luthfipun.hiltmvi.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import github.luthfipun.hiltmvi.domain.model.User

@Entity(tableName = "user")
data class UserCache(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var email: String,
    var firstName: String,
    var lastName: String,
    var avatar: String
) {
    fun toUserDto(): User {
        return User(
            id, email, firstName, lastName, avatar
        )
    }
}