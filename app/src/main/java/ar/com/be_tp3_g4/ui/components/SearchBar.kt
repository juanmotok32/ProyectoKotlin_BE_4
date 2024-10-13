package ar.com.be_tp3_g4.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

//un import extra q saque de chat para el icono de filtro (hay q meterlo como dependency)
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.ui.graphics.Color


//los value (statte) y lasa funciones (modifican el state) se reciben x parametro, x mas quee dsps no las usemos xq no lo piden
@Composable
fun SearchBar(
    searchValue: String,
    onSearch: (String) -> Unit,
    onFilter: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = searchValue, onValueChange = onSearch,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(19.dp),

        //icono del principio (lupita)
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_desc)
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.15f),
            focusedContainerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },

        //icono del fondo (filtrart o lo q sea q necesitemos
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.FilterList,
                contentDescription = stringResource(id = R.string.filtrar), //no enbcuentro el icono de filtrar, esto que traje es lo mas parecido q encontre
                modifier = Modifier.clickable {
                    onFilter
                }
            )
        }
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    BE_TP3_G4Theme {
        SearchBar(searchValue = "", onSearch = {}, onFilter = {})
    }
}