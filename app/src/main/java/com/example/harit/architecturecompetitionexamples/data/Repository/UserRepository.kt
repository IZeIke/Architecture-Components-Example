package com.example.harit.architecturecompetitionexamples.data.Repository

import androidx.lifecycle.LiveData
import com.example.harit.architecturecompetitionexamples.data.Entity.User
import com.example.harit.architecturecompetitionexamples.data.local.UserDao

class UserRepository(val localSource: UserDao) {

    fun getAllUser(): LiveData<List<User>> {
        return localSource.getAllUser()
    }

    fun getUserFromId(id : String) : LiveData<User> {
        return localSource.getUserFromId(id)
    }

    fun insert(user: User) {
        localSource.insert(user)
    }


}