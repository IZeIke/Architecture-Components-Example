package com.example.harit.architecturecompetitionexamples.ui.FeedPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.harit.architecturecompetitionexamples.data.Entity.User
import com.example.harit.architecturecompetitionexamples.data.Repository.UserRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserFeedViewModel : ViewModel() {


    @Inject
    lateinit var userRepository : UserRepository

    private lateinit var userList : MutableLiveData<List<User>>

    fun getAllUser() : LiveData<List<User>>{
        if(!::userList.isInitialized){
            userList = MutableLiveData()
            loadUser()
        }
        return userList
    }

    private fun loadUser() {
        userRepository.getAllUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { it , _ ->
                    userList.value = it
                }
    }

}