package com.example.harit.architecturecompetitionexamples.data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User {

    @PrimaryKey
    @ColumnInfo(name = "id")
    lateinit var id: String

    @ColumnInfo(name = "name")
    lateinit var name: String

    @ColumnInfo(name = "username")
    lateinit var username: String

    @ColumnInfo(name = "password")
    lateinit var password: String

}