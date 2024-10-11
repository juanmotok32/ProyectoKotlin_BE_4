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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun Card(
    goToDetails: () -> Unit,
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    description: String,
    addToCart: () -> Unit
) {

    val borderColor = Color(0xFFE2E2E2)

    OutlinedCard(
        onClick = goToDetails,
        modifier = Modifier
            .width(174.dp)
            .height(248.dp),

        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, borderColor),
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center

        ) {

            Image(
                painter = painterResource(id = R.drawable.product01),
                contentDescription = "imagenCategoria1",
                modifier = Modifier
                    .size(120.dp)
                    .align((Alignment.CenterHorizontally))
                    .padding(10.dp)


            )
            Text(text = title)
            Text(text = description)
            Spacer(modifier = Modifier.weight(3f))


            Row(


            ) {
                Text(
                    text = price,
                    modifier = Modifier
                        .weight(3f)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(3f))

                Button(
                    onClick = { addToCart },
                    modifier = Modifier
                        .weight(2f)
                        .padding(1.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )

                ) {

                }
            }

        }

    }
}

@Preview
@Composable
fun Card() {


    BE_TP3_G4Theme {

        val pescado = "Pescado"
        val price = "11,2"
        val description = "1kg, Price"

        Card(
            goToDetails = { /*TODO*/ },
            title = pescado,
            price = price,
            description = description,
            addToCart = {})


    }
}

