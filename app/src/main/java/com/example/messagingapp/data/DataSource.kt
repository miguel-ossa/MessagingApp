package com.example.messagingapp.data

import com.example.messagingapp.model.Message
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Data source interface for message and user operations
 */
interface DataSource {
    suspend fun sendMessage(message: Message)
    suspend fun receiveMessage(message: Message)
    fun getMessages(userId: String): Flow<List<Message>>
    fun getUsers(): Flow<List<User>>
    fun getUserById(userId: String): Flow<User?>
    suspend fun saveUser(user: User)
}