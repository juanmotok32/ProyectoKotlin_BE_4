package ar.com.be_tp3_g4.ui.screens

import BtnSumaTotal
import CheckoutDialog
import CustomBottomNavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.TopAppBar
import ar.com.be_tp3_g4.ui.components.CartProductItem
import ar.com.be_tp3_g4.data.productList
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.navigation.NavDestinations

@Composable
fun CartScreen(navController: NavController) {

    var showDialog = remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(tittle = R.string.myCart_topbar, menu = { })
    }, bottomBar = {
        CustomBottomNavBar(
            items = Items,
            selectedItem = "Cart",
            onItemSelected = {},
            navController = navController
        )
    }, content = { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                items(productList) { item ->
                    CartProductItem(
                        name = item.name,
                        image = item.image,
                        price = item.price,
                        content = item.content,

                        )
                }
            }
            BtnSumaTotal(
                onClick = { showDialog.value = true }, prices = productList,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )


            /* Btn(
                 onClick = { showDialog.value = true },
                 text = R.string.btn_cart,
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(16.dp)
             )*/
        }
        CheckoutDialog(showDialog = showDialog.value,
            onDismiss = { showDialog.value = false },
            goToHome = { navController.navigate(NavDestinations.Home) })


    })
}
/*

@Preview
@Composable
fun PreviewCartScreen() {
    BE_TP3_G4Theme {
        CartScreen()
    }
}
*/
