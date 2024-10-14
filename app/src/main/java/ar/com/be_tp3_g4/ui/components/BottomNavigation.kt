import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.com.be_tp3_g4.data.Items
import ar.com.be_tp3_g4.navigation.NavDestinations
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme


@Composable
fun CustomBottomNavBar(
    items: List<BottomNavItem>,
    onItemSelected: (Int) -> Unit,
    navController: NavController
) {
    var selectedIndex by remember { mutableStateOf(0) }

    NavigationBar{
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = { Text(item.label) },
                selected = selectedIndex == index,
                onClick = {navController.navigate(item.destination)
                    selectedIndex = index
                    onItemSelected(index)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.secondary, // Aca se selecciona el icono y se pone en verde
                    unselectedIconColor = MaterialTheme.colorScheme.inversePrimary
                )
            )
        }
    }
}

data class BottomNavItem(val label: String, val icon: Int, val destination: NavDestinations)

@Preview(showBackground = true)
@Composable
fun CustomBottomNavBarPreview() {
    val navController = rememberNavController()
    BE_TP3_G4Theme {
        CustomBottomNavBar(items = Items, onItemSelected = {}, navController = navController)
    }
}
