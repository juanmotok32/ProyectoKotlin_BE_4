import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomNavBar(
    items: List<BottomNavItem>,
    onItemSelected: (Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }

    NavigationBar(
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(35.dp)
                    )
                },
                label = { Text(item.label) },
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    onItemSelected(index)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Green, // Aca se selecciona el icono y se pone en verde
                    unselectedIconColor = Color.Black
                )
            )
        }
    }
}

data class BottomNavItem(val label: String, val icon: Int)

@Preview(showBackground = true)
@Composable
fun CustomBottomNavBarPreview() {
    val items = listOf(
        BottomNavItem("Shop", R.drawable.shop),
        BottomNavItem("Explore", R.drawable.explore),
        BottomNavItem("Cart", R.drawable.cart),
        BottomNavItem("Favorite", R.drawable.favorite),
        BottomNavItem("Account", R.drawable.account)
    )

    BE_TP3_G4Theme {
        CustomBottomNavBar(items = items, onItemSelected = {})
    }
}
