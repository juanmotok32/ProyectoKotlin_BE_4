package ar.com.be_tp3_g4.model

data class User (
    val username: String,
    val email: Double,
    val password: String,
    val zone: String,
    val area: String

    /* le podemos agregar:
    zone - area (enums)
    orders (List<Order>)
    favourites (List<T>)
    Cart (un carrito, q a su vez tiene (List<Product>?)
     */
)