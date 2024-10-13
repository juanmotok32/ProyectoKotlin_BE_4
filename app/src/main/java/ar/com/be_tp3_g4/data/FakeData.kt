package ar.com.be_tp3_g4.data

import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.model.randomColor
import ar.com.be_tp3_g4.model.Category

val Lugares: List<String> = listOf("Olivos", "Martinez", "Moreno", "San Martin", "Tres de Febrero")

val Areas: List<String> = listOf("Villa Bosh", "Billinghurst", "Caseros", "La Reja", "Catonas")



val categories = listOf(
    Category(
        name = "Fresh fruit & vegetables",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Cooking Oil & Ghee",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Meat & Fish",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Bakery & Snack",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Dairy & Eggs",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Beverages",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Frozen Foods",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Snacks",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Care Products",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Deli",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Condiment",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Category(
        name = "Cleaning",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    )
)
