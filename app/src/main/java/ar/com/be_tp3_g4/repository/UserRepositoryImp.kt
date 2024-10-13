package ar.com.be_tp3_g4.repository


import ar.com.be_tp3_g4.api.RetrofitService


/*recbo la instancia de retrofit*/
/*implemento la interfaz del repo para crear los metodos del crud*/
/*esta es mi capo de repositorio, retrofit seria mi capa de servicios*/

class UserRepositoryImp(private val api: RetrofitService = RetrofitService()) : UserRepository {
    override suspend fun login(username: String, password: String): String {
        return api.login(username, password)
    }
}



