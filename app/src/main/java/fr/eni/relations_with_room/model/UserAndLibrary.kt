package fr.eni.relations_with_room.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithPlaylists(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userCreatorId"
    )
    val playlists: List<Playlist>
)