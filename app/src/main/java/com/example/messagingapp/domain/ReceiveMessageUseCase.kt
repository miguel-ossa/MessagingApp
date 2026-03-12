package com.example.messagingapp.domain

import com.example.messagingapp.data.MessageRepository
import com.example.messagingapp.model.Message
import javax.inject.Inject

/**
 * Use case for receiving messages
 */
class ReceiveMessageUseCase @Inject constructor(private val repository: MessageRepository) {
    suspend operator fun invoke(message: Message) {
        repository.receiveMessage(message)
    }
}