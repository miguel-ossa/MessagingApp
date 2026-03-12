package com.example.messagingapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.messagingapp.model.Message
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Message entity
 */
@Dao
interface MessageDao {
    @Insert
    suspend fun insertMessage(message: Message)

    @Query("SELECT * FROM message WHERE senderId = :userId OR receiverId = :userId ORDER BY timestamp ASC")
    fun getMessagesByUserId(userId: String): Flow<List<Message>>

    @Query("SELECT * FROM message WHERE id = :id")
    suspend fun getMessageById(id: String): Message?
}