package ar.com.be_tp3_g4.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.TopAppBar
import ar.com.be_tp3_g4.ui.components.CartProductItem
import ar.com.be_tp3_g4.data.productList
import CustomBottomNavBarPreview

@Composable
fun CartScreen() {

    Scaffold(
        topBar = {
            TopAppBar(tittle = R.string.myCart_topbar, menu = { })
        },
        bottomBar = {
            CustomBottomNavBarPreview()
        },
        content = { paddingValues ->
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

                Btn(
                    onClick = { /* Go to Checkout action */ },
                    text = R.string.btn_cart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewCartScreen() {
    BE_TP3_G4Theme {
        CartScreen()
    }
}
