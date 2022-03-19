package com.rahul.roomdatabasepractice.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:User)

    @Query("SELECT * FROM user_db ORDER BY id ASC")
    fun readUserData():LiveData<List<User>>
}