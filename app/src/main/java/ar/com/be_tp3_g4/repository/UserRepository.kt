package ar.com.be_tp3_g4.repository

interface UserRepository {

    /*ACA IRIA  EL CRUD, PERO SOLO ME PIDE LOGIN*/

    suspend fun login(username: String, password: String): String //(el token me devuelve)
}