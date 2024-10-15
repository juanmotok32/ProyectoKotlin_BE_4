package ar.com.be_tp3_g4.navigation

import androidx.navigation.NavController
import kotlinx.serialization.Serializable


//aca vamos a agregar todas las screens a las q vamos a poder navegar
//sealed = clase sellada, no se puedeen crear subclases
sealed interface NavDestinations {

    @Serializable   //sus instancias pueden ser convertidas a json, xml....
    data object Splash : NavDestinations

    @Serializable
    data object Onboarding: NavDestinations

    @Serializable
    data object Login: NavDestinations

    @Serializable
    data object Register: NavDestinations

    @Serializable
    data object Location: NavDestinations

    @Serializable
    data object Home : NavDestinations

    @Serializable
    data object Explore: NavDestinations

    @Serializable
    data object MyCart: NavDestinations

    @Serializable
    data object Favorites: NavDestinations

    @Serializable
    data object Account: NavDestinations

    @Serializable
    data object BottomBar: NavDestinations

    @Serializable
    data object SearchScreen: NavDestinations


}