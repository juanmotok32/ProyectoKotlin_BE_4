package ar.com.be_tp3_g4.ui.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun CardCategory(name: String, @DrawableRes image: Int, color: Color) {

    val borderColor = color.copy(alpha = 0.7f)  // 70% opacidad
    val backgroundColor = color.copy(alpha = 0.1f)  // 10% opacidad
    OutlinedCard(
        onClick = { /* GO TO CATEGORY DETAIL*/ },
        modifier = Modifier
            .width(174.dp)
            .height(189.dp)
            .padding(4.dp),


        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        border = BorderStroke(1.dp, borderColor),


        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Image(
                painter = painterResource(id = R.drawable.categoria1),
                contentDescription = "imagenCategoria1",
                modifier = Modifier.size(100.dp)
            )
            //Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = name, style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center)

        }

    }
}

@Preview
@Composable
fun SeeCardCategory() {


    BE_TP3_G4Theme {
/*

        val pescado = "Pescado"
        CardCategory(name = pescado, )
*/


    }
}

