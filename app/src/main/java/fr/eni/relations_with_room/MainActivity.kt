package fr.eni.relations_with_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.stetho.Stetho
import fr.eni.relations_with_room.dao.UserDao
import fr.eni.relations_with_room.dao.utils.AppDatabase
import fr.eni.relations_with_room.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Stetho.initializeWithDefaults(this);

        setContentView(R.layout.activity_main)

        var userDao = AppDatabase.getInstance(application).userDao()

        GlobalScope.launch{
            userDao.insert(User(20,"XXX","XXX", Address("Alma","Britany","Rennes",35000)))
        }
    }
}