import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import ar.com.be_tp3_g4.R

@Composable
fun Desplegable(
    @StringRes label: Int, placeholder: String,
    opciones: List<String>, modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            label = {
                Text(
                    text = stringResource(id = label),
                    color = MaterialTheme.colorScheme.tertiary
                )
            },
            value = selectedItem,
            onValueChange = { selectedItem = it },
            modifier = modifier
                .fillMaxWidth()
                .height(78.55.dp)
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.primary,    //fondo cuando no escribo
                focusedContainerColor = MaterialTheme.colorScheme.primary,       //fondo escribiendo
                /*unfocusedIndicatorColor = MaterialTheme.colorScheme.tertiary,*/ // Color del borde desenfocado
                focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,     // borde enfocado
                unfocusedTextColor = MaterialTheme.colorScheme.tertiary,          // Color de texto desenfocado
                focusedTextColor = MaterialTheme.colorScheme.tertiary       // Color de texto enfocado
            ),
            placeholder = {
                Text(text = placeholder, color = MaterialTheme.colorScheme.tertiary)
            },
            trailingIcon = {
                Icon(icon, contentDescription = null, Modifier.clickable { expanded = !expanded })
            },
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .background(MaterialTheme.colorScheme.primary),
        ) {
            opciones.forEach { label ->
                DropdownMenuItem(
                    text = { Text(text = label, color = MaterialTheme.colorScheme.inversePrimary) },
                    onClick = {
                        selectedItem = label
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun DropDownMenuPreview() {
    Desplegable(
        label = R.string.zone,
        opciones = listOf("Olivos", "Martinez", "CABA"),
        placeholder = "hola"
    )
}
