package com.rahul.roomdatabasepractice.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao():UserDAO

    companion object{
        @Volatile
        private var INSTANCE:UserDatabase?=null
        fun getDatabase(context: Context):UserDatabase{
            if (INSTANCE!=null)
                return INSTANCE!!
            synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
            }
            return INSTANCE!!
        }
    }
}