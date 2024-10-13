package ar.com.be_tp3_g4.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import ar.com.be_tp3_g4.model.Producto
import ar.com.be_tp3_g4.ui.components.Card
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun CatalogScreen() {
    val products = listOf(
        Producto("Pescado", 11.2, "hola", "1kg, Price"),
        Producto("Carne", 15.5, "hola", "1kg, Price"),
        Producto("Pollo", 8.3, "hola", "1kg, Price"),
        Producto("Verduras", 5.0, "hola", "1kg, Price"),
        Producto("Frutas", 7.5, "hola", "1kg, Price"),
        Producto("Lácteos", 3.2, "hola", "1kg, Price")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(products) { product ->
            Card(
                goToDetails = { /* Navegar a detalles */ },
                producto = product,
                addToCart = { /* Agregar al carrito */ },
                modifier = Modifier
                    .padding(8.dp) // Espacio entre tarjetas
                    .width(150.dp) // Ajusta el ancho de la tarjeta solo aquí
                    .height(200.dp) // Ajusta la altura de la tarjeta solo aquí
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewCatalogScreen() {
    BE_TP3_G4Theme {
        CatalogScreen()
    }
}
