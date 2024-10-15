import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.be_tp3_g4.model.Product
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun BtnSumaTotal(onClick: () -> Unit, prices: List<Product>, modifier: Modifier = Modifier) {


    val totalSum = prices.sumOf { it.price.toDouble() }


    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(19.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "                     Go to Checkout",
                fontSize = 18.sp,
            )
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "$${"%.2f".format(totalSum)}",
                    fontSize = 14.sp
                )
            }
        }
    }
}
/*
@Preview
@Composable
fun BtnPreview() {
    BE_TP3_G4Theme {
        BtnSumaTotal(onClick = { *//*TODO*//* }, prices = listOf(10.99f, 20.50f, 5.75f))
    }
}*/
