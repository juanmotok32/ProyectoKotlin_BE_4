package ar.com.be_tp3_g4.ui.screens

import CustomBottomNavBar
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
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.data.categories
import ar.com.be_tp3_g4.ui.components.CardCategory
import ar.com.be_tp3_g4.ui.components.SearchBar
import ar.com.be_tp3_g4.ui.components.TopAppBar
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.navigation.NavDestinations
import ar.com.be_tp3_g4.ui.components.FilterDialog

@Composable
fun ExploreScreen(navController: NavController) {

    var searchText by remember { mutableStateOf("") }
    var showFilter = remember {
        mutableStateOf(false)

    }
    Scaffold(containerColor = MaterialTheme.colorScheme.primary, topBar = {
        TopAppBar(tittle = R.string.find_products, menu = { })
    },


        bottomBar = {
            CustomBottomNavBar(
                items = Items,
                selectedItem = "Explore",
                onItemSelected = {},
                navController = navController
            )
        },

        content = { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Spacer(modifier = Modifier.padding(2.dp))

                SearchBar(searchValue = searchText,
                    onSearch = {newValue -> searchText = newValue
                        navController.navigate("searchScreen/${searchText}")  },
                    onFilter = { showFilter.value = true })





                LazyVerticalGrid(
                    columns = GridCells.Fixed(2), modifier = Modifier.padding(16.dp)
                ) {
                    items(categories) { category ->
                        CardCategory(
                            name = category.name,
                            image = category.image,
                            color = category.color,
                            onClick = {navController.navigate("categories/${category.name}")}

                            )
                    }
                }
            }

            FilterDialog(showDialog = showFilter, onDismiss = { showFilter.value = false })
        })


}


/*
@Preview
@Composable
fun showScreen() {

    BE_TP3_G4Theme {
        ExploreScreen()
    }
}*/
