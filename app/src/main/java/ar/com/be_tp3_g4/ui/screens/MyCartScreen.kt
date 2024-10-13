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
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.BtnCant
import ar.com.be_tp3_g4.ui.components.TopAppBar


data class CartItem(val name: String, val details: String, val price: String, val imageRes: Int, var quantity: Int)

@Composable
fun CartScreen() {
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
                    items(cartItems.value) { item ->
                        CartItemRow(item = item)
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

@Composable
fun CartItemRow(item: CartItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f),
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier.size(80.dp)
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.weight(2f),
        ) {
            Column{
                Text(text = item.name, style = MaterialTheme.typography.bodyLarge)
                Text(text = item.details, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    BtnCant(
                        onClick = { /* fnc */ },
                        modifier = Modifier.size(50.dp),
                        text = R.string.quitar,
                        textColor = MaterialTheme.colorScheme.inversePrimary,
                        color = MaterialTheme.colorScheme.primary,
                        borderColor = Color.Black,

                        )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${item.quantity}", fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    BtnCant(
                        onClick = { /* fnc */ },
                        modifier = Modifier.size(50.dp),
                        text = R.string.agregar,
                        textColor = MaterialTheme.colorScheme.secondary,
                        color = MaterialTheme.colorScheme.primary,
                        borderColor = Color.Black
                    )
                }

            }

        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "✕",
                modifier = Modifier.clickable { /* fnc */ },
                fontSize = 20.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = item.price,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )


        }


    }
}

@Preview
@Composable
fun PreviewCartScreen() {
    BE_TP3_G4Theme {
        CartScreen()
    }
}
