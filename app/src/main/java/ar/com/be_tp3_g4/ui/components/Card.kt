package ar.com.be_tp3_g4.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.model.Product

@Composable
fun Card(
    goToDetails: () -> Unit,
    addToCart: () -> Unit,
    product: Product,

    ) {
    OutlinedCard(
        onClick = goToDetails,
        modifier = Modifier
            .width(200.dp)
            .height(265.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onTertiary),
    ) {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.primary)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center

            ) {

                // Imagen
                Image(
                    painter = painterResource(id = R.drawable.product01),
                    contentDescription = "imagenCategoria1",
                    modifier = Modifier
                        .size(100.dp) // Reducir el tamaño de la imagen
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 4.dp) // Espaciado entre la imagen y el texto
                )

                // Nombre del producto
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 1.dp) // Reducir el espaciado
                )
                Text(
                    text = "${product.content}, Price",  // Agregar ", Price"
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(bottom = 1.dp) // Espaciado entre la descripción y el precio
                )


                Spacer(modifier = Modifier.weight(5f)) // Mandar al fondo el boton

                // Fila con precio y botón
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$${product.price}",
                        color = MaterialTheme.colorScheme.inversePrimary,
                        style = MaterialTheme.typography.titleLarge
                    )
                    BtnCant(
                        onClick = addToCart,
                        text = R.string.agregar,
                        color = MaterialTheme.colorScheme.secondary,
                        textColor = Color.White,

                        )
                }
            }
        }
    }
}



