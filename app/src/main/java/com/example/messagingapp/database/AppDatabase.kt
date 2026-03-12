package com.example.messagingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.messagingapp.model.Message
import com.example.messagingapp.model.User

/**
 * Main database class for the messaging app
 */
@Database(
    entities = [Message::class, User::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Access to Message DAO
     */
    abstract fun messageDao(): MessageDao

    /**
     * Access to User DAO
     */
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Get the database instance
         */
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "messaging_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}