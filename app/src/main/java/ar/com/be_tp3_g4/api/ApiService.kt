package ar.com.be_tp3_g4.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    /*OPCIONALES, deberia llevarlos a otro archivo*/
    /*
    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>


    @GET("products/categories")
    suspend fun getCategories(): Response<CetegoryResponse>
    */

    /*OBLIGATORIO*/
    @POST("auth/login") //lo "variable" (lo que cambia de la URL
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>     // le paso un @Body de tipo LoginRequest, me devuelve un LoginResponse
}