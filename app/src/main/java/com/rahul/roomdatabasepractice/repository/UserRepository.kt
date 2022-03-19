package com.rahul.roomdatabasepractice.repository

import androidx.lifecycle.LiveData
import com.rahul.roomdatabasepractice.model.User
import com.rahul.roomdatabasepractice.model.UserDAO

class UserRepository(private val userDao:UserDAO) {
    val readAllData:LiveData<List<User>> = userDao.readUserData()

    suspend fun addUser(user:User){
        userDao.insertUser(user)
    }
}