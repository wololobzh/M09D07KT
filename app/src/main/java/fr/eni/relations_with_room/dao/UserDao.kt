package fr.eni.relations_with_room.dao

import androidx.room.*
import fr.eni.relations_with_room.model.UserAndLibrary


@Dao
interface UserDao {
    @Transaction
    @Query("SELECT * FROM User")
    fun getUsersAndLibraries(): List<UserAndLibrary>
}
