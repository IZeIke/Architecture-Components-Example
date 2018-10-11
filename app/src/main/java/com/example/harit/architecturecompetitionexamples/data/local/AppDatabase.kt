package com.example.harit.architecturecompetitionexamples.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.harit.architecturecompetitionexamples.data.Entity.User

@Database(entities = [User::class],version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        fun getAppDatabase(context: Context): AppDatabase =
                Room.databaseBuilder(context, AppDatabase::class.java, "db_app").build()
    }

    abstract fun userDao() : UserDao
}