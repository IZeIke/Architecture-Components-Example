package com.example.harit.architecturecompetitionexamples.data.Repository

import androidx.lifecycle.LiveData
import com.example.harit.architecturecompetitionexamples.data.Entity.User
import com.example.harit.architecturecompetitionexamples.data.local.UserDao
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class UserRepository(val localSource: UserDao) {

    fun getAllUser(): Single<List<User>> {

        return localSource.getAllUser()
    }

    fun getUserFromUsername(id : String,password : String) : Single<User> {
        return localSource.getUserFromId(id,password)
    }

    fun insert(user: User) {
        localSource.insert(user)
    }


}