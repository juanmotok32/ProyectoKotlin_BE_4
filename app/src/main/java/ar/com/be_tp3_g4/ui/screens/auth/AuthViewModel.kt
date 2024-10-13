package ar.com.be_tp3_g4.ui.screens.auth

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import ar.com.be_tp3_g4.api.LoginResponse
import ar.com.be_tp3_g4.api.LoginResult
import ar.com.be_tp3_g4.repository.UserRepository
import ar.com.be_tp3_g4.repository.UserRepositoryImp
import kotlinx.coroutines.launch

class AuthViewModel(private val userRepository: UserRepositoryImp) : ViewModel() {
    private val _loginResult = MutableLiveData<LoginResult?>()
    val loginResult: LiveData<LoginResult?> get() = _loginResult

    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var email by mutableStateOf("")
        private set

    fun onUsernameChange(newUsername: String) {
        username = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun onEmailChange(newEmail: String) {
        email = newEmail
    }


    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loginResult.value = null //reinicia el valor
            try {
                val token = userRepository.login(username, password)
                // Login exitoso: actualiza loginResult con el token y marca como éxito
                _loginResult.value = LoginResult(token = token, isSuccess = true, errorMessage = null)
            } catch (e: Exception) {
                // Log de error para debug
                Log.e("AuthViewModel", "Login error: ${e.message}", e)
                // Login fallido: actualiza loginResult con el error
                _loginResult.value = LoginResult(token = null, isSuccess = false, errorMessage = e.message)
            }
        }
    }


    class AuthViewModelFactory(private val userRepository: UserRepositoryImp) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AuthViewModel(userRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

