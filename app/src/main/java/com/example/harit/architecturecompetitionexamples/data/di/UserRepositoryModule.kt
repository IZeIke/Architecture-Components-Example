package com.example.harit.architecturecompetitionexamples.data.di

import android.app.Application
import android.content.Context
import com.example.harit.architecturecompetitionexamples.data.Repository.UserRepository
import com.example.harit.architecturecompetitionexamples.data.local.AppDatabase
import com.example.harit.architecturecompetitionexamples.data.local.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserRepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userDao : UserDao) : UserRepository{
        return UserRepository(userDao)
    }

    @Provides
    @Singleton
    fun provideUserDao(application : Application) : UserDao{
        return AppDatabase.getAppDatabase(application).userDao()
    }

}