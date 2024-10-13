package ar.com.be_tp3_g4.navigation

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
    data object ExploreScreen: NavDestinations
}