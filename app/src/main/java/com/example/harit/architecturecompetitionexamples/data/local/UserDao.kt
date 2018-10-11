package com.example.harit.architecturecompetitionexamples.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.harit.architecturecompetitionexamples.data.Entity.User

@Dao
interface UserDao {

    @Insert
    fun insert(users: User)

    @Query("SELECT * FROM user")
    fun getAllUser() : LiveData<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserFromId(id : String) : LiveData<User>
}