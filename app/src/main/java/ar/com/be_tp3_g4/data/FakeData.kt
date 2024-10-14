package ar.com.be_tp3_g4.data

import BottomNavItem
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.model.randomColor
import ar.com.be_tp3_g4.model.Categorie
import ar.com.be_tp3_g4.navigation.NavDestinations

val Lugares: List<String> = listOf("Olivos", "Martinez", "Moreno", "San Martin", "Tres de Febrero")

val Areas: List<String> = listOf("Villa Bosh", "Billinghurst", "Caseros", "La Reja", "Catonas")


val Items = listOf(
    BottomNavItem("Shop", R.drawable.shop, NavDestinations.Home),
    BottomNavItem("Explore", R.drawable.explore, NavDestinations.Explore),
    BottomNavItem("Cart", R.drawable.cart, NavDestinations.MyCart),
    BottomNavItem("Favorite", R.drawable.favorite, NavDestinations.Favorites),
    BottomNavItem("Account", R.drawable.account, NavDestinations.Account)
)


val categories = listOf(
    Categorie(
        name = "Fresh fruit & vegetables",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Cooking Oil & Ghee",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Meat & Fish",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Bakery & Snack",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Dairy & Eggs",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Beverages",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Frozen Foods",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Snacks",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Care Products",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Deli",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Condiment",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    ),
    Categorie(
        name = "Cleaning",
        image = R.drawable.category01, // Reemplaza con el recurso correcto
        color = randomColor()
    )
)
