package fr.eni.relations_with_room.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val userId: Long,
    val name: String,
    val age: Int
)


