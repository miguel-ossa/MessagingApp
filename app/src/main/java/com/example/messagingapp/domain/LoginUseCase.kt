package com.example.messagingapp.domain

import com.example.messagingapp.data.DataSource
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case for logging in a user
 */
class LoginUseCase @Inject constructor(private val dataSource: DataSource) {
    suspend operator fun invoke(username: String, password: String): Result<User> {
        return try {
            // In a real implementation, this would:
            // 1. Validate credentials against backend
            // 2. Authenticate with server
            // 3. Retrieve user data

            val users = dataSource.getUsers().first()
            val user = users.find { it.username == username }

            if (user != null) {
                // In a real app, we would compare hashed passwords
                // For demo purposes, we'll just check if password matches (insecure)
                if (user.password == password) {
                    Result.success(user)
                } else {
                    Result.failure(Exception("Invalid password"))
                }
            } else {
                Result.failure(Exception("User not found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}