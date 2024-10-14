package ar.com.be_tp3_g4.ui.screens

import CustomBottomNavBar
import CustomBottomNavBarPreview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.components.TopAppBar
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.data.productList
import ar.com.be_tp3_g4.ui.components.Card
import ar.com.be_tp3_g4.ui.components.HorizontalList

@Composable
fun HomeScreen(
    goToExplore : () -> Unit, navController : NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(tittle = R.string.search_screen_name, menu = { })
        },

        bottomBar = {
            CustomBottomNavBar(items = Items, onItemSelected = {}, navController = navController)
        },

        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(10.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        contentAlignment = Alignment.Center

                    ) {
                        Text(
                            text = stringResource(id = R.string.actual_location),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium

                        )
                    }

                }
                item {
                    Image(
                        painter = painterResource(R.drawable.banner),
                        contentDescription = "bannerHome",
                        modifier = Modifier
                            .height(150.dp)
                            //.width(380.dp)
                            .fillMaxWidth()
                    )
                }
                item {
                    Text(
                        text = "Exclusive Offers",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                //EXCLUSIVE OFFERS
                item {


                    HorizontalList(items = productList) { product ->
                        Card(
                            goToDetails = { /*TODO*/ },
                            addToCart = { /*TODO*/ },
                            product = product
                        )

                    }
                }
                item {
                    Text(
                        text = "Best Sellings",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                item {

                    //LISTA DE MEJORES VENDIDOS
                    HorizontalList(items = productList) { product ->
                        Card(
                            goToDetails = { /*TODO*/ },
                            addToCart = { /*TODO*/ },
                            product = product
                        )

                    }
                }

            }
        }
    )
}

/*

@Preview
@Composable
fun showHomeScreen() {

    BE_TP3_G4Theme {
        HomeScreen()
    }
}*/
