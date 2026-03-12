package com.example.messagingapp.database

import androidx.room.TypeConverter
import com.example.messagingapp.model.MessageStatus
import java.util.Date

/**
 * Type converters for Room database
 */
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromMessageStatus(status: MessageStatus?): String? {
        return status?.name
    }

    @TypeConverter
    fun toMessageStatus(status: String?): MessageStatus? {
        return status?.let { MessageStatus.valueOf(it) }
    }
}
