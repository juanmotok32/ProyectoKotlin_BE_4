

package ar.com.be_tp3_g4.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import ar.com.be_tp3_g4.model.Product
import ar.com.be_tp3_g4.data.productList
import ar.com.be_tp3_g4.ui.components.Card
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun Categories() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    )  {
        items(productList.take(6)) { product ->  // Cambiado aquí
            Card(
                goToDetails = {},
                addToCart = {},
                product = product
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCategories() {
    BE_TP3_G4Theme {
        Categories()
    }
}
