package com.example.messagingapp.domain

import com.example.messagingapp.data.DataSource
import com.example.messagingapp.model.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for getting messages
 */
class GetMessagesUseCase @Inject constructor(private val dataSource: DataSource) {
    suspend operator fun invoke(userId: String): Flow<List<Message>> {
        return dataSource.getMessages(userId)
    }
}