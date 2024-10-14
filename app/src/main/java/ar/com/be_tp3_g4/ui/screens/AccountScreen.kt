package ar.com.be_tp3_g4.ui.screens

import CustomBottomNavBar
import CustomBottomNavBarPreview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.model.User
import ar.com.be_tp3_g4.ui.components.TopAppBar
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import logout

//data class Account(val name: String, val email: String, val imageRes: Int)
data class MenuItem(val title: String, val iconRes: Int, val isSwitch: Boolean = false)

@Composable
fun AccountScreen(navController: NavController, user: User) {
    Scaffold(
        topBar = {
            TopAppBar(tittle = R.string.account, menu = { })
        },
        bottomBar = {
            CustomBottomNavBar(
                items = Items,
                selectedItem = "Account",
                onItemSelected = {},
                navController = navController
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(Color(0xFFFCFCFC))
            ) {
                DetailsAccount() // user
                Spacer(modifier = Modifier.height(16.dp))
                MenuScreen()
            }
        },
        floatingActionButton = {
            logout()
        }
    )
}


@Composable
fun DetailsAccount() { // user: User
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(R.drawable.gatotierno), // id = user.imageRes
                    contentDescription = "Enrique", //  user.username
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Enrique", style = MaterialTheme.typography.bodyLarge) //                     Text(text = user.username, style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.cambiarnombre),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(2.dp),
                        tint = Color(0xFF53B175)
                    )
                }
                Text(text = "juanse@gmail.com", style = MaterialTheme.typography.bodySmall) //                 Text(text = user.email, style = MaterialTheme.typography.bodySmall)

            }
        }
    }
}

@Composable
fun MenuScreen() {
    val menuItems = listOf(
        MenuItem("Orders", R.drawable.cart),
        MenuItem("My Details", R.drawable.dni),
        MenuItem("Delivery Address", R.drawable.adress),
        MenuItem("Payment Methods", R.drawable.tarjeta),
        MenuItem("Promo Cord", R.drawable.promocard),
        MenuItem("Notifications", R.drawable.notificacion),
        MenuItem("Help", R.drawable.help),
        MenuItem("Dark mode", R.drawable.darkmode, isSwitch = true)
    )
    Column(modifier = Modifier.padding(16.dp)) {
        menuItems.forEachIndexed { index, item ->
            MenuItemView(item)
            if (index < menuItems.size - 1) {
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }
    }
}

@Composable
fun MenuItemView(item: MenuItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = item.iconRes),
            contentDescription = item.title,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = item.title, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        if (item.isSwitch) {
            val switchState = remember { false }
            Switch(
                checked = switchState,
                onCheckedChange = { }
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.flecha),
                contentDescription = null,
                modifier = Modifier.size(10.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewAccountScreen() {

    BE_TP3_G4Theme {
        val navController = rememberNavController()
        val exampleAccount = User(
            username = "Enrique Iglesias",
            password = "",
            email = "EnriqueIglesias@gmail.com",
            imageRes = R.drawable.gatotierno
        )
        AccountScreen(user = exampleAccount, navController = navController)
    }
}
