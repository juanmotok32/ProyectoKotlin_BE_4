package ar.com.be_tp3_g4.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.data.categories
import ar.com.be_tp3_g4.data.productList


@Composable
fun FilterDialog(
    showDialog: MutableState<Boolean>, onDismiss: () -> Unit) {
    val categories = categories
    val brands = productList
    val LIMIT_LIST_ITEMS = 4

    if (showDialog.value) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(dismissOnClickOutside = false)
        ) {
            Surface(
                modifier = Modifier
                    .height(601.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Categories", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.padding(5.dp))
                    categories.take(LIMIT_LIST_ITEMS).forEach { category ->
                        FilterRow(text = category.name)
                    }


                    Text(text = "Brands", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.padding(10.dp))
                    brands.take(LIMIT_LIST_ITEMS).forEach { product ->
                        FilterRow(
                            text = product.brand,
                        )

                    }
                    Btn(onClick = { onDismiss() }, text = R.string.apply_filter)
                }

            }

        }

    }
}


@Composable
fun FilterRow(
    text: String

) {
    var isChecked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { isChecked = !isChecked }
            .fillMaxWidth()) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { checked -> isChecked = checked },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.secondary,
                uncheckedColor = MaterialTheme.colorScheme.tertiary,
                checkmarkColor = MaterialTheme.colorScheme.primary

            )
        )
        Text(
            text = text, color = if (isChecked) Color(0xFF4CAF50) else MaterialTheme.colorScheme.inversePrimary
        )
    }
}
/*

@Preview
@Composable
fun PreviewFilter() {
    BE_TP3_G4Theme {

        FilterDialog(
            showDialog = true,
            onDismiss = { */
/*TODO*//*
 }
        )

    }
}
*/
