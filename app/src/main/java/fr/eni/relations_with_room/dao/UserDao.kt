package fr.eni.relations_with_room.dao

import androidx.room.*
import fr.eni.relations_with_room.model.*


@Dao
interface UserDao {
    @Transaction
    @Query("SELECT * FROM User")
    fun getUsersWithPlaylists(): List<UserWithPlaylists>

    @Insert
    fun insert(library: Playlist)

    @Insert
    fun insert(user: User)
}
