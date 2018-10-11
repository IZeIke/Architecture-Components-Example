package com.example.harit.architecturecompetitionexamples.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.harit.architecturecompetitionexamples.data.Entity.User
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert
    fun insert(users: User)

    @Query("SELECT * FROM user")
    fun getAllUser() : LiveData<List<User>>

    @Query("SELECT * FROM user WHERE username = :id AND password = :password")
    fun getUserFromId(id : String,password : String) : Single<User>
}