package fr.eni.relations_with_room.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true) var id:Long = 0L,
    var lastName:String,
    var firstname:String,
    @Embedded
    val address: Address?
)
