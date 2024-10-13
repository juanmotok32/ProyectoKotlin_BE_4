package ar.com.be_tp3_g4.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Category(

    val name: String,
    @DrawableRes val image: Int,
    val color: Color
)

fun randomColor(): Color {
    return Color(
        alpha = Random.nextInt(256),
        red = Random.nextInt(256),
        green = Random.nextInt(256),
        blue = Random.nextInt(256)
    )
}
