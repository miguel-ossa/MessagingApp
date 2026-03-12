package com.example.messagingapp.domain

import com.example.messagingapp.data.DataSource
import com.example.messagingapp.model.User
import javax.inject.Inject

/**
 * Use case for registering a new user
 */
class RegisterUseCase @Inject constructor(private val dataSource: DataSource) {
    suspend operator fun invoke(username: String, email: String, password: String): Result<User> {
        return try {
            // In a real implementation, this would:
            // 1. Validate input data
            // 2. Hash the password (this is a simplified version - in reality you'd use proper hashing)
            // 3. Send registration request to backend
            // 4. Save user data locally

            // Generate a simple ID for demo purposes
            val userId = "user_${System.currentTimeMillis()}"

            val newUser = User(
                id = userId,
                username = username,
                email = email,
                password = password, // In a real app, this would be hashed
                publicKey = "", // In real app, this would be generated securely
                createdAt = System.currentTimeMillis()
            )

            dataSource.saveUser(newUser)
            Result.success(newUser)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}