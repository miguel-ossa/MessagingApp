package com.example.messagingapp.data

import com.example.messagingapp.database.MessageDao
import com.example.messagingapp.database.UserDao
import com.example.messagingapp.model.Message
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of DataSource interface using Room DAOs
 */
class DataSourceImpl @Inject constructor(
    private val messageDao: MessageDao,
    private val userDao: UserDao
) : DataSource {

    override suspend fun sendMessage(message: Message) {
        messageDao.insertMessage(message)
    }

    override suspend fun receiveMessage(message: Message) {
        messageDao.insertMessage(message)
    }

    override fun getMessages(userId: String): Flow<List<Message>> {
        return messageDao.getMessagesByUserId(userId)
    }

    override fun getUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override fun getUserById(userId: String): Flow<User?> {
        return userDao.getUserById(userId)
    }

    override suspend fun saveUser(user: User) {
        userDao.insertUser(user)
    }
}
