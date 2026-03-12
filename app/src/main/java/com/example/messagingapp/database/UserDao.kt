package com.example.messagingapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for User entity
 */
@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserById(id: String): Flow<User?>
}