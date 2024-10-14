package ar.com.be_tp3_g4.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.screens.CartScreen
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun CartProductItem(name: String, content: String, @DrawableRes image: Int, price: Float ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = name,
                modifier = Modifier.size(80.dp)
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.weight(2f),
        ) {
            Column(
                modifier = Modifier
                    .width(200.dp)  // Establecemos el ancho fijo de la columna a 200.dp
            ){
                Text(text = name, style = MaterialTheme.typography.bodyLarge)
                Text(text = content, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    BtnCant(
                        onClick = { /* fnc */ },
                        modifier = Modifier.size(50.dp),
                        text = R.string.quitar,
                        textColor = MaterialTheme.colorScheme.inversePrimary,
                        color = MaterialTheme.colorScheme.primary,
                        borderColor = Color.Black,

                        )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "4", fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    BtnCant(
                        onClick = { /* fnc */ },
                        modifier = Modifier.size(50.dp),
                        text = R.string.agregar,
                        textColor = MaterialTheme.colorScheme.secondary,
                        color = MaterialTheme.colorScheme.primary,
                        borderColor = Color.Black
                    )
                }

            }

        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "✕",
                modifier = Modifier.clickable { /* fnc */ },
                fontSize = 20.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = String.format("$%.2f", price),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )


        }


    }
}

@Preview
@Composable
fun PreviewCartScreen() {
    BE_TP3_G4Theme {
        CartScreen()
    }
}