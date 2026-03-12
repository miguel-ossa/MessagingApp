package com.example.messagingapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Message data class representing a single message
 */
@Entity(tableName = "message")
data class Message(
    @PrimaryKey
    val id: String,
    val senderId: String,
    val receiverId: String,
    val content: String,
    val timestamp: Date,
    val status: MessageStatus = MessageStatus.SENT
)

/**
 * Status of a message
 */
enum class MessageStatus {
    PENDING,
    SENT,
    DELIVERED,
    READ
}