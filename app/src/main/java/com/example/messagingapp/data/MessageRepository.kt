package com.example.messagingapp.data

import com.example.messagingapp.model.Message
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Repository for managing message and user data
 */
class MessageRepository(private val dataSource: DataSource) {

    suspend fun sendMessage(message: Message) {
        dataSource.sendMessage(message)
    }

    suspend fun receiveMessage(message: Message) {
        dataSource.receiveMessage(message)
    }

    fun getMessages(userId: String): Flow<List<Message>> {
        return dataSource.getMessages(userId)
    }

    fun getUsers(): Flow<List<User>> {
        return dataSource.getUsers()
    }

    fun getUserById(userId: String): Flow<User?> {
        return dataSource.getUserById(userId)
    }

    suspend fun saveUser(user: User) {
        dataSource.saveUser(user)
    }
}