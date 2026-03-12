package com.example.messagingapp.domain

import com.example.messagingapp.data.MessageRepository
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for getting users
 */
class GetUsersUseCase @Inject constructor(private val repository: MessageRepository) {
    operator fun invoke(): Flow<List<User>> {
        return repository.getUsers()
    }
}

/**
 * Use case for getting a specific user
 */
class GetUserUseCase @Inject constructor(private val repository: MessageRepository) {
    operator fun invoke(userId: String): Flow<User?> {
        return repository.getUserById(userId)
    }
}