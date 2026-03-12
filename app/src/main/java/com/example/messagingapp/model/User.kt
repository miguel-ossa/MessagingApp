package com.example.messagingapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * User data class representing a user in the messaging app
 */
@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val id: String,
    val username: String,
    val email: String,
    val password: String,
    val publicKey: String,
    val createdAt: Long
)