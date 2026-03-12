package com.example.messagingapp.di

import android.content.Context
import com.example.messagingapp.database.AppDatabase
import com.example.messagingapp.database.MessageDao
import com.example.messagingapp.database.UserDao
import com.example.messagingapp.data.DataSource
import com.example.messagingapp.data.DataSourceImpl
import com.example.messagingapp.data.MessageRepository
import com.example.messagingapp.encryption.EncryptionManager
import com.example.messagingapp.networking.NetworkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Main dependency injection module for the application
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideMessageDao(database: AppDatabase) = database.messageDao()

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase) = database.userDao()

    @Provides
    @Singleton
    fun provideDataSource(
        messageDao: MessageDao,
        userDao: UserDao
    ): DataSource {
        return DataSourceImpl(messageDao, userDao)
    }

    @Provides
    @Singleton
    fun provideMessageRepository(dataSource: DataSource): MessageRepository {
        return MessageRepository(dataSource)
    }

    @Provides
    @Singleton
    fun provideEncryptionManager(): EncryptionManager {
        return EncryptionManager()
    }

    @Provides
    @Singleton
    fun provideNetworkManager(): NetworkManager {
        return NetworkManager()
    }
}