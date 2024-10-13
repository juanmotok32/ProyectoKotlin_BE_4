package ar.com.be_tp3_g4.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun BtnCant(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @StringRes text: Int,
    color: Color = MaterialTheme.colorScheme.secondary,
    textColor: Color = Color.White,
    borderColor: Color? = null,
    size : Dp = 60.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(size),
        shape = RoundedCornerShape(17.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        border = if (borderColor != null) BorderStroke(2.dp, borderColor) else null
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(text),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = textColor
            )
        }
    }
}


@Preview
@Composable
fun BtnPlusPreview() {
    BE_TP3_G4Theme {

            // Ejemplo con borde
            BtnCant(
                onClick = { /*TODO*/ },
                text = R.string.agregar,
                color = MaterialTheme.colorScheme.secondary,
                textColor = Color.White,
                borderColor = Color.Black  // Con borde negro
            )

    }
}
