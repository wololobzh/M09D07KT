package fr.eni.relations_with_room.dao

import android.os.FileObserver.DELETE
import androidx.lifecycle.LiveData
import androidx.room.*
import fr.eni.relations_with_room.model.User


@Dao
interface UserDao {
    /**
     * Le Long retourné représente l'identitifiant de la personne insérée en base de données.
     */
    @Insert
    fun insert(user: User): Long

    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun get(id: Long): User

}
