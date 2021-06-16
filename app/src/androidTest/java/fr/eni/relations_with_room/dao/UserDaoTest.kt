package fr.eni.relations_with_room.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import fr.eni.relations_with_room.dao.utils.AppDatabase
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

    }

    @Test
    fun get() {

    }
}