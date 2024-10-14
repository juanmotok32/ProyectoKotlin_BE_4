import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.BtnCant
import ar.com.be_tp3_g4.ui.components.TopAppBar
import ar.com.be_tp3_g4.ui.components.CartProductItem
import ar.com.be_tp3_g4.data.productList

data class CartItem(val name: String, val details: String, val price: String, val imageRes: Int, var quantity: Int)

@Composable
fun CartScreen(navController : NavController) {
    val cartItems = remember {
        mutableStateOf(
            listOf(
                CartItem("Bell Pepper Red", "1kg, Price", "$4.99", R.drawable.coke, 1),
                CartItem("Egg Chicken Red", "4pcs, Price", "$1.99", R.drawable.diet_coke, 1),
                CartItem("Organic Bananas", "12kg, Price", "$3.00", R.drawable.coke, 1),
                CartItem("Ginger", "250gm, Price", "$2.99", R.drawable.coke, 1)
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(tittle = R.string.myCart_topbar, menu = { })
        },
        bottomBar = {CustomBottomNavBar(items = Items, onItemSelected = {}, navController = navController)},

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
/*
@Preview
@Composable
fun PreviewCartScreen() {
    BE_TP3_G4Theme {
        CartScreen()
    }
}*/
