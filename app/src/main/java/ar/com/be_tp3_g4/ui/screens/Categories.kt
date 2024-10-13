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
import ar.com.be_tp3_g4.model.Producto
import ar.com.be_tp3_g4.ui.components.Card
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun Categories() {
    val products = listOf(
        Producto("Diet Coke", 1.99, "hola", "355ml, Price"),
        Producto("Sprite Can", 1.50, "hola", "325ml, Price"),
        Producto("Apple & Grape ", 15.99, "hola", "2L, Price"),
        Producto("Orange Juice", 15.99, "hola", "2L, Price"),
        Producto("Coca Cola Can", 4.99, "hola", "325ml, Price"),
        Producto("Pepsi Can", 4.99, "hola", "330ml, Price")
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp), //Bajar la lista
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    )  {
        items(products) { product ->
            Card(
                goToDetails = { /* Detalles? */ },
                producto = product,
                addToCart = { /* Agregar al carrito? */ },
                modifier = Modifier
                    .padding(8.dp)
                    .width(150.dp)
                    .height(200.dp)
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
