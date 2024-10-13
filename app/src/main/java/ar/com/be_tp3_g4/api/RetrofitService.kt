package ar.com.be_tp3_g4.api

import android.util.Log
import ar.com.be_tp3_g4.api.Constant.FAKESTORE_URL
import ar.com.be_tp3_g4.repository.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService : UserRepository { //tambien podria implementar Products, categories, etc
    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create()) //agrego esa lib para convertir de json a obj y viceversa
        .baseUrl(FAKESTORE_URL)
        .build()
    private val api = retrofit.create(ApiService::class.java)   //api es una instancia de apiservice

    override suspend fun login(username: String, password: String): String {
        val response = api.login(LoginRequest(username, password))
        // Imprime la respuesta para verificar el estado y el cuerpo
        Log.d("RetrofitService", "Response code: ${response.code()}, body: ${response.body()}")

        return when {
            response.isSuccessful -> response.body()?.token ?: throw Exception("No existe token")
            response.code() == 401 -> throw Exception("Credenciales incorrectas.")
            else -> throw Exception("Error en el login: ${response.message()}")
        }
    }

}