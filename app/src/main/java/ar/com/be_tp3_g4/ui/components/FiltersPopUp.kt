import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import ar.com.be_tp3_g4.ui.components.Btn

@Composable
fun FilterDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(dismissOnClickOutside = false)
        ) {
            Surface(
                modifier = Modifier
                    .height(600.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = "Categories",
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 23.sp, fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.weight(0.1f))

                    CategoryList()


                    Text(
                        text = "Brands",
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 23.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 1.dp)
                    )
                    Spacer(modifier = Modifier.weight(0.1f))

                    BrandList()
                    Spacer(modifier = Modifier.weight(1f)) //Bajar el botón

                    Btn(
                        onClick = { /*func*/ },
                        text = R.string.apply_Filter
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryList() {
    val categories = listOf("Eggs", "Noodles and Pasta", "Chips & Crisps", "Fast Food")
    Column {
        categories.forEach { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun BrandList() {
    val brands = listOf("Individual Callection", "Cocola", "ifad", "Kazi Farmas")
    Column {
        brands.forEach { brand ->
            BrandItem(brand)
        }
    }
}

@Composable
fun CategoryItem(category: String) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isChecked = !isChecked }
            .padding(vertical = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Text(
            text = category,
            color = if (isChecked) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onBackground,

            )
    }
}

@Composable
fun BrandItem(brand: String) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isChecked = !isChecked }
            .padding(vertical = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Text(
            text = brand,
            color = if (isChecked) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onBackground,

            )
    }
}
@Preview
@Composable
fun FilterScreen() {
    val showDialog = remember { mutableStateOf(true) }

    BE_TP3_G4Theme {
        FilterDialog(showDialog.value, { showDialog.value = false })
    }
}
