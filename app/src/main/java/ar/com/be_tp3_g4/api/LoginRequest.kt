package ar.com.be_tp3_g4.api

data class LoginRequest(val username: String, val password: String)

//esto es lo que el user va a mandar para loguearse, y le voy a mandar a la api para q  ue valide
