package com.example.messagingapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.messagingapp.domain.GetMessagesUseCase
import com.example.messagingapp.domain.SendMessageUseCase
import com.example.messagingapp.domain.GetCurrentUserUseCase
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
    private val getCurrentUserUseCase: GetCurrentUserUseCase
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
            // In a real implementation, this would get the current user from storage
            // For now, we'll just simulate loading
        }
    }
}