package com.example.messagingapp.domain

import com.example.messagingapp.data.DataSource
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for getting the currently logged-in user
 */
class GetCurrentUserUseCase @Inject constructor(private val dataSource: DataSource) {
    operator fun invoke(): Flow<User?> {
        // This would typically get the current user from shared preferences, secure storage,
        // or a session manager. For now we'll return a flow that gets the first user.
        return dataSource.getUserById("current_user")
    }
}