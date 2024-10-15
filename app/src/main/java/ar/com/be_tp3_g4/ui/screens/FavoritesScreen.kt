package ar.com.be_tp3_g4.ui.screens

import CustomBottomNavBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.FavoriteItemProduct
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import ar.com.be_tp3_g4.ui.components.TopAppBar
import ar.com.be_tp3_g4.data.favoritesProduccts
import CustomBottomNavBarPreview
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.navigation.NavDestinations
import ar.com.be_tp3_g4.ui.components.ErrorDialog

@Composable
fun FavoritesScreen(navController: NavController) {
    // Usa una lista mutable de productos favoritos
    val favoriteItems = remember { mutableStateListOf(*favoritesProduccts.toTypedArray()) }
    var showError = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(tittle = R.string.favorites_topbar, menu = { })
        },
        bottomBar = {
            CustomBottomNavBar(
                items = Items,
                selectedItem = "Favorite",
                onItemSelected = {},
                navController = navController
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    items(favoriteItems) { item ->
                        FavoriteItemProduct(
                            name = item.name,
                            content = item.content,
                            price = item.price,
                            image = item.image,
                            onRemove = { favoriteItems.remove(item) }  // Eliminar de la lista
                        )
                    }
                }

                Btn(
                    onClick = { showError.value = true },
                    text = R.string.favorites_btn,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    )
    ErrorDialog(showDialog = showError.value, onDismiss = { showError.value = false },
        goHome = { navController.navigate(NavDestinations.Home) })


}

/*

@Preview(showBackground = true)
@Composable
fun PreviewFavoritesScreen() {
    BE_TP3_G4Theme {
        FavoritesScreen()
    }
}
*/
