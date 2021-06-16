package fr.eni.relations_with_room.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import fr.eni.relations_with_room.dao.utils.AppDatabase
import fr.eni.relations_with_room.model.Address
import fr.eni.relations_with_room.model.User
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class UserDaoTest {
    private lateinit var userDao: UserDao
    private lateinit var db: AppDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        userDao = db.userDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insert() {
            val userAvant = User(3, "Romain", "Roussel", Address("Alma", "Britany", "Rennes", 35000))
            val id = userDao.insert(userAvant)
            assertEquals(id, 3)
    }

    @Test
    fun get() {
       runBlocking {
            val userAvant = User(4,"Romain","Roussel", Address("Alma","Britany","Rennes",35000))
            val id = userDao.insert(userAvant)
            val userApres = userDao.get(id)
            assertEquals(userAvant.id,userApres.id)
            assertEquals(userAvant.lastName,userApres.lastName)
            assertEquals(userAvant.firstname,userApres.firstname)
            assertEquals(userAvant.address?.street,userApres.address?.street)
            assertEquals(userAvant.address?.state,userApres.address?.state)
            assertEquals(userAvant.address?.city,userApres.address?.city)
            assertEquals(userAvant.address?.postCode,userApres.address?.postCode)
        }
    }
}