package com.rahul.roomdatabasepractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rahul.roomdatabasepractice.model.User
import com.rahul.roomdatabasepractice.model.UserDatabase
import com.rahul.roomdatabasepractice.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
     val readAllData:LiveData<List<User>>
     val repository:UserRepository
    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}