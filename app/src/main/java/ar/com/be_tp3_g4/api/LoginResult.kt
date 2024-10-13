package ar.com.be_tp3_g4.api

data class LoginResult(
    val isSuccess: Boolean,
    val token: String? = null,
    val errorMessage: String? = null
)