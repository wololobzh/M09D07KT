package fr.eni.relations_with_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.facebook.stetho.Stetho
import fr.eni.relations_with_room.dao.UserDao
import fr.eni.relations_with_room.dao.utils.AppDatabase
import fr.eni.relations_with_room.model.Playlist
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
            userDao.insert(User(1,"XXX",20))
            userDao.insert(User(2,"YYY",30))
            userDao.insert(User(3,"OOO",40))

            userDao.insert(Playlist(1,1,"Run"))
            userDao.insert(Playlist(2,1,"Work"))

            val liste = userDao.getUsersWithPlaylists()

            liste.forEach { valeur -> Log.i("ACOS","item : " + valeur.user?.name + " -- " + valeur.playlists?.size) }
        }
    }
}