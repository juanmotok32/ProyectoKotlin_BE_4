package ar.com.be_tp3_g4.ui.screens.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel: ViewModel() {
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var username by mutableStateOf("")  //la dejo aca x si hacemos un username o algo x el estilo
        private set
}