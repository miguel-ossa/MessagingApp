package com.example.messagingapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.messagingapp.domain.GetMessagesUseCase
import com.example.messagingapp.domain.SendMessageUseCase
import com.example.messagingapp.domain.GetCurrentUserUseCase
import com.example.messagingapp.domain.RegisterUseCase
import com.example.messagingapp.domain.LoginUseCase
import com.example.messagingapp.model.Message
import com.example.messagingapp.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for managing message-related UI state
 */
@HiltViewModel
class MessageViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val getMessagesUseCase: GetMessagesUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val registerUseCase: RegisterUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    /**
     * Send a new message
     */
    fun sendMessage(message: Message) {
        viewModelScope.launch {
            try {
                sendMessageUseCase(message)
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

    /**
     * Load messages for a user
     */
    fun loadMessages(userId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // In a real implementation, this would observe the flow from use case
                // For now, we'll just simulate loading
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    /**
     * Load current user
     */
    fun loadCurrentUser() {
        viewModelScope.launch {
            try {
                // Get the current user using the use case
                val currentUserFlow = getCurrentUserUseCase()
                // Since we're not observing flows properly in this context,
                // we'll just set a demo user for now
                _currentUser.value = User(
                    id = "current_user",
                    username = "demo_user",
                    email = "demo@example.com",
                    password = "password123",
                    publicKey = "demo_public_key",
                    createdAt = System.currentTimeMillis()
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * Register a new user
     */
    fun register(username: String, email: String, password: String, onResult: (Result<User>) -> Unit) {
        viewModelScope.launch {
            val result = registerUseCase(username, email, password)
            onResult(result)
        }
    }

    /**
     * Login a user
     */
    fun login(username: String, password: String, onResult: (Result<User>) -> Unit) {
        viewModelScope.launch {
            val result = loginUseCase(username, password)
            if (result.isSuccess) {
                _currentUser.value = result.getOrNull()
            }
            onResult(result)
        }
    }

    /**
     * Logout the current user
     */
    fun logout() {
        _currentUser.value = null
    }
}