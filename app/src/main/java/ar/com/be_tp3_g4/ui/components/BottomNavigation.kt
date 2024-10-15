import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    selectedItem: String,
    onItemSelected: (Int) -> Unit,
    navController: NavController
) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
        items.forEachIndexed { index, item ->
            val isSelected = item.label == selectedItem
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = { Text(item.label) },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.destination)
                    onItemSelected(index)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.inversePrimary, // Color verde para el seleccionado, negro para el no seleccionado
                    unselectedIconColor = if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.inversePrimary,
                   /* indicatorColor = MaterialTheme.colorScheme.inversePrimary  esto es para cambiar el color de fondo cuando esta seleccionado*/
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
        CustomBottomNavBar(
            items = Items,
            selectedItem = "Favorite",
            onItemSelected = {},
            navController = navController
        )
    }
}
