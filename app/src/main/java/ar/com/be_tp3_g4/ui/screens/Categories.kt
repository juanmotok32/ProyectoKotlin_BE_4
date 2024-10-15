package ar.com.be_tp3_g4.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.data.productList
import ar.com.be_tp3_g4.ui.components.Card
import ar.com.be_tp3_g4.ui.components.TopAppBar

@Composable
fun Categories(categoryName: String, navController: NavController) {

    val filteredProducts = productList.filter { it.category == categoryName }


    Scaffold(topBar = {
        TopAppBar(tittle = categoryName, menu = { })
    }, content = { paddind ->

        if (filteredProducts.isNotEmpty()) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddind),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(filteredProducts) { product ->  // Cambiado aquí
                    Card(
                        goToDetails = {navController.navigate("productDetail/${product.name}") },
                        addToCart = {},
                        product = product
                    )
                }

            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddind)
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = stringResource(id = R.string.empty_list),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 1.dp),
                    color = MaterialTheme.colorScheme.tertiary// Reducir el espaciado
                )
            }

        }
    })
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewCategories() {
    BE_TP3_G4Theme {
        val categoryName = "Condiment"
        Categories(categoryName)
    }
}*/
