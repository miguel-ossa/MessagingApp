package com.example.messagingapp.domain

import com.example.messagingapp.data.DataSource
import com.example.messagingapp.model.Message
import javax.inject.Inject

/**
 * Use case for sending messages
 */
class SendMessageUseCase @Inject constructor(private val dataSource: DataSource) {
    suspend operator fun invoke(message: Message) {
        dataSource.sendMessage(message)
    }
}