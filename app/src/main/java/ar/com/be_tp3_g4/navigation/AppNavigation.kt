package ar.com.be_tp3_g4.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.com.be_tp3_g4.helpers.WindowSizeHelper
import ar.com.be_tp3_g4.ui.screens.OnboardingScreen
import ar.com.be_tp3_g4.ui.screens.SplashScreen
import ar.com.be_tp3_g4.ui.screens.auth.AuthViewModel
import ar.com.be_tp3_g4.ui.screens.auth.LoginScreen
import ar.com.be_tp3_g4.ui.screens.auth.RegisterScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun AppNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val windowSizeHelper = WindowSizeHelper()

    NavHost(
        navController = navController,
        startDestination = NavDestinations.Splash   /*la primera screen en visualizarse va a ser la de splash*/
    ) {

        composable<NavDestinations.Splash> {
            LaunchedEffect(key1 = null) {
                delay(2.5.seconds)  /*va a tener un delay de 2,5 segundos (sujeto a modificacion) y pasa a la siguiente screen*/
            navController.popBackStack()    //esto me sirve para sacar la screen de la pila (si apretan volver para atras, no pueden volver aca)
                navController.navigate(NavDestinations.Onboarding)
            }
            SplashScreen()
        }

        composable<NavDestinations.Onboarding> {
            OnboardingScreen(
                getStarted = { navController.navigate(NavDestinations.Login) },    //aca le paso onClick a la scree de welcome, para que al apretar el boton me lleve a la screen siguiente
                windowSizeHelper = windowSizeHelper
                )
        }

        composable<NavDestinations.Login> {
            LoginScreen(
                authViewModel = authViewModel,
                signUp = { navController.navigate(NavDestinations.Register) },
                windowSizeHelper = windowSizeHelper
            )
        }

        composable<NavDestinations.Register> {
            RegisterScreen(
                authViewModel = authViewModel,
                signIn = { navController.navigate(NavDestinations.Login) }
            )
        }
    }
}