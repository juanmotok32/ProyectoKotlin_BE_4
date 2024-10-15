package ar.com.be_tp3_g4.ui.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
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
    tittle: Any,
    menu: () -> Unit
) {
    CenterAlignedTopAppBar(title = {
        when (tittle) {
            is Int -> {
                Text(
                    text = stringResource(tittle),
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            is String -> {
                Text(
                    text = tittle,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
    }, modifier = Modifier.background(MaterialTheme.colorScheme.primary),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(onClick = { menu() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(id = R.string.menu_icon_desc),
                    tint = MaterialTheme.colorScheme.inversePrimary


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