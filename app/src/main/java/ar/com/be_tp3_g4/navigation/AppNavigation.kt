package ar.com.be_tp3_g4.navigation

import CustomBottomNavBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.helpers.WindowSizeHelper
import ar.com.be_tp3_g4.model.Product
import ar.com.be_tp3_g4.model.User
import ar.com.be_tp3_g4.repository.UserRepositoryImp
import ar.com.be_tp3_g4.ui.screens.AccountScreen
import ar.com.be_tp3_g4.ui.screens.CartScreen
import ar.com.be_tp3_g4.ui.screens.ExploreScreen
import ar.com.be_tp3_g4.ui.screens.FavoritesScreen
import ar.com.be_tp3_g4.ui.screens.HomeScreen
import ar.com.be_tp3_g4.ui.screens.OnboardingScreen
import ar.com.be_tp3_g4.ui.screens.ProductDetailScreen
import ar.com.be_tp3_g4.ui.screens.SelectLocationScreen
import ar.com.be_tp3_g4.ui.screens.SplashScreen
import ar.com.be_tp3_g4.ui.screens.auth.AuthViewModel
import ar.com.be_tp3_g4.ui.screens.auth.LoginScreen
import ar.com.be_tp3_g4.ui.screens.auth.RegisterScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun AppNavigation(userRepository: UserRepositoryImp) {


    val navController = rememberNavController()
    val windowSizeHelper = WindowSizeHelper()
    val authViewModel: AuthViewModel =
        viewModel(factory = AuthViewModel.AuthViewModelFactory(userRepository))

    NavHost(
        navController = navController,
        startDestination = NavDestinations.Onboarding   /*la primera screen en visualizarse va a ser la de splash*/
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
                windowSizeHelper = windowSizeHelper,
                userRepository = userRepository,
                successLogin = { navController.navigate(NavDestinations.Home) }
            )
        }

        composable<NavDestinations.Register> {
            RegisterScreen(
                authViewModel = authViewModel,
                signIn = { navController.navigate(NavDestinations.Login) },
                windowSizeHelper = windowSizeHelper,
                goToLocation = { navController.navigate(NavDestinations.Location) },
                userRepository = userRepository

            )
        }

        composable<NavDestinations.Location> {
            SelectLocationScreen(/*
                authViewModel = authViewModel,
                signIn = { navController.navigate(NavDestinations.Login) },
                windowSizeHelper = windowSizeHelper*/
                goBack = { navController.popBackStack() },
                submit = { navController.navigate(NavDestinations.Home) }
            )
        }
        composable<NavDestinations.BottomBar> {
            CustomBottomNavBar(
                items = Items,
                selectedItem = "Orders",
                onItemSelected = {},
                navController = navController
            )
        }


        composable<NavDestinations.Home> {
            HomeScreen(goToExplore = {navController.navigate(NavDestinations.Explore)}, navController = navController)
        }

        composable<NavDestinations.Explore> {
            ExploreScreen(navController = navController)
        }

        composable<NavDestinations.MyCart> {
            CartScreen(navController = navController)
        }

        composable<NavDestinations.Favorites> {
            FavoritesScreen(navController = navController)
        }

        composable<NavDestinations.Account> {
            AccountScreen(navController = navController, user = User("", " ", "", 0)) /*consumir de fake data despues*/
        }

        composable<NavDestinations.ProductDetail> {
            ProductDetailScreen(
                product = Product("", "", 0.0f, 0, "", ""),
                onAddToCart = {/*funcion vacia, la logica debe estar en un vm pero no es requerida*/})
        }

    }

}
