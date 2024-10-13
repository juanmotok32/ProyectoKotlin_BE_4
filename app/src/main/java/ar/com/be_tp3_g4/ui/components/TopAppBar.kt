package ar.com.be_tp3_g4.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

//no le meto un modifier xq siempre es igual el top bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    @StringRes tittle: Int,
    menu: () -> Unit,
) {
    CenterAlignedTopAppBar(title = { Text(text = stringResource(tittle),
        color = MaterialTheme.colorScheme.inversePrimary)
    },
        navigationIcon = {
            IconButton(onClick = { menu() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(id = R.string.menu_icon_desc)
                )
            }
        })
}


@Preview(showBackground = true)
@Composable
fun TopApVarPreview() {
    BE_TP3_G4Theme {
        TopAppBar(
            tittle = R.string.shop,
            menu = {}   /*en la vista, esta funcion despliega el pop up*/
        )
    }
}