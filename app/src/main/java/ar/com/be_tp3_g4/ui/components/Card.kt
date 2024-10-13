package ar.com.be_tp3_g4.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
            .width(174.dp)
            .height(248.dp)
            .padding(4.dp),

        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(product.image),
                contentDescription = "imagenCategoria1",
                modifier = Modifier
                    .size(100.dp)
                    .align((Alignment.CenterHorizontally))
                    .padding(10.dp)
                    .weight(5f)


            )
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(3f)
            )
            Text(text = product.content, color = MaterialTheme.colorScheme.tertiary)

            Row(
                modifier = Modifier.weight(2f)
            ) {
                Text(
                    text = "$${product.price}0",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    color = MaterialTheme.colorScheme.inversePrimary
                )
                Spacer(modifier = Modifier.weight(3f))

                BtnCant(onClick = { addToCart() }, text = R.string.agregar)

            }

        }

    }
}


