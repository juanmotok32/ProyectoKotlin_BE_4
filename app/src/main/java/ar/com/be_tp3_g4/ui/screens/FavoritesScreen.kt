package ar.com.be_tp3_g4.ui.screens
import CustomBottomNavBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.TopAppBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

data class FavoriteItem(val name: String, val size: String, val price: String, val imageRes: Int)

@Composable
fun FavoritesScreen(navController : NavController) {
    val favoriteItems = remember {
        listOf(
            FavoriteItem("Sprite Can", "325ml", "$1.50", R.drawable.sprite),
            FavoriteItem("Diet Coke", "355ml", "$1.99", R.drawable.diet_coke),
            FavoriteItem("Apple & Grape Juice", "2L", "$15.50", R.drawable.apple_juice),
            FavoriteItem("Coca Cola Can", "325ml", "$4.99", R.drawable.coke),
            FavoriteItem("Pepsi Can", "330ml", "$4.99", R.drawable.pepsi)
        )
    }

    Scaffold(

        bottomBar = {
            CustomBottomNavBar(
                items = Items,
                selectedItem = "Favorite",
                onItemSelected = {},
                navController = navController
            )},
        topBar = {
            TopAppBar(tittle = R.string.favorites_topbar, menu = { })
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
                        FavoriteItemRow(item)
                    }
                }

                Btn(
                    onClick = { /*func*/ },
                    text = R.string.favorites_btn,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    )
}

@Composable
fun TopBar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineLarge, color = Color.Black)
    }
}

@Composable
fun FavoriteItemRow(item: FavoriteItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* NAVIGATE TO ITEM DETAILS */ },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = item.name, style = MaterialTheme.typography.bodyLarge)
                Text(text = "${item.size}, Price", style = MaterialTheme.typography.bodySmall)
            }
        }
        Text(
            text = item.price,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
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
