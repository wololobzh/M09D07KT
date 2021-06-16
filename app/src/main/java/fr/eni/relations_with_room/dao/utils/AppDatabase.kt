package fr.eni.relations_with_room.dao.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import fr.eni.relations_with_room.dao.UserDao
import fr.eni.relations_with_room.model.Address
import fr.eni.relations_with_room.model.User

import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun ioThread(f : () -> Unit) {
    IO_EXECUTOR.execute(f)
}

@Database(entities = arrayOf(User::class), version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "la_base_de_donnees"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                ioThread {
                                    var dao = INSTANCE?.userDao();
                                    dao?.insert(User(1,"Dupont","Anthony", Address("Alma","Britany","Rennes",35000)))
                                    dao?.insert(User(2,"Dupont","Nicolas", Address("Brest","Britany","Rennes",35000)))
                                    dao?.insert(User(3,"Dupont","Sylvie", Address("Cartier","Britany","Rennes",35000)))
                                    dao?.insert(User(4,"Dupont","Dominique", Address("Saint Malo","Britany","Rennes",35000)))
                                    dao?.insert(User(5,"Dupont","Leïla", Address("Parc","Britany","Rennes",35000)))
                                    dao?.insert(User(6,"Dupont","Michel", Address("Jardin","Britany","Rennes",35000)))
                                    dao?.insert(User(7,"Dupont","Claudine", Address("Mairie","Britany","Rennes",35000)))
                                }
                            }
                        })
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
