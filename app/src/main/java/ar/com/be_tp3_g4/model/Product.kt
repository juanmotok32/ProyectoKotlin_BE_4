package ar.com.be_tp3_g4.model

import androidx.annotation.DrawableRes

data class Product(
    val name: String,
    val brand: String,
    val price: Float,
    @DrawableRes val image: Int,
    val description: String,
    val content: String,
    /*agregar de ser necesario*/
)
