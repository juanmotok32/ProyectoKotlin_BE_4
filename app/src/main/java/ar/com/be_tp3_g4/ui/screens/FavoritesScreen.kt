import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.FavoriteItemProduct
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import ar.com.be_tp3_g4.ui.components.TopAppBar
import CustomBottomNavBarPreview
import androidx.annotation.DrawableRes
import ar.com.be_tp3_g4.data.favoritesProduccts


data class FavoriteItem(val name: String, val size: String, val price: String, val imageRes: Int)

@Composable
fun FavoritesScreen() {

    Scaffold(
        topBar = {
            TopAppBar(tittle = R.string.favorites_topbar, menu = { })
        },
        bottomBar = {
            CustomBottomNavBarPreview()
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
                    items(favoritesProduccts) { item ->
                        FavoriteItemProduct(
                            name = item.name,
                            content = item.content,
                            price = item.price,
                            image = item.image
                        )
                    }
                }

                Btn(
                    onClick = { /* fnc */ },
                    text = R.string.favorites_btn,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFavoritesScreen() {
    BE_TP3_G4Theme {
        FavoritesScreen()
    }
}
