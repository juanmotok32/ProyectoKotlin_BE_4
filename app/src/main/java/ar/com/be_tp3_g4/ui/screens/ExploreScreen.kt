package ar.com.be_tp3_g4.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.data.categories
import ar.com.be_tp3_g4.ui.components.CardCategory
import ar.com.be_tp3_g4.ui.components.SearchBar
import ar.com.be_tp3_g4.ui.components.TopAppBar
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import androidx.compose.foundation.lazy.grid.items

@Composable
fun ExploreScreen() {
    Scaffold(
        topBar = {
            TopAppBar(tittle = R.string.find_products, menu = { })
        },

        bottomBar = {
            TopAppBar(tittle = R.string.find_products, menu = { })
        },

        content = { padding ->
            // Aquí va el contenido principal de la pantalla
            // Asegúrate de aplicar el padding
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.padding(2.dp))

                SearchBar(
                    searchValue = stringResource(id = R.string.placeholder_search),
                    onSearch = { },
                    onFilter = { /*TODO*/ }) //COMPLETAR LA IMPLEMENTACION

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(categories) { category ->
                        CardCategory(
                            name = category.name,
                            image = category.image,
                            color = category.color,

                        )
                    }
                }


            }
        }
    )
}


@Preview
@Composable
fun showScreen() {


    BE_TP3_G4Theme {
        ExploreScreen()
    }
}