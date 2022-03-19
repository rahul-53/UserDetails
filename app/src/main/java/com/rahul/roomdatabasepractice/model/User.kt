package com.rahul.roomdatabasepractice.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_db")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int
    )