// BTNContador.kt
package ar.com.be_tp3_g4.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun Counter() {
    var count by remember { mutableStateOf(1) }
    Row(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { if (count > 0) count-- },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
        ) {
            Text(text = "-")
        }
        Button(
            onClick = {},
            modifier = Modifier
                .padding(horizontal = 1.dp),
            border = BorderStroke(1.dp, Color.Gray),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
        ) {
            Text(text = count.toString())
        }
        Button(
            onClick = { count++ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Green)
        ) {
            Text(text = "+")
        }
    }

}
@Preview(showBackground = true)
@Composable
fun PreviewCounter() {
    BE_TP3_G4Theme { // Asegúrate de utilizar tu tema personalizado
        Counter()
    }
}