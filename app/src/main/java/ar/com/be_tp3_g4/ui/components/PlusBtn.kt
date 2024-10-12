package ar.com.be_tp3_g4.ui.components

import androidx.annotation.StringRes
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun BtnPlus(onClick: () -> Unit, @StringRes text: Int, color: Color = MaterialTheme.colorScheme.secondary,
    textColor: Color = Color.White, modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(60.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(text),
                fontSize = 24.sp,
                color = textColor //
            )
        }
    }
}

@Preview
@Composable
fun BtnPlusPreview() {
    BE_TP3_G4Theme {
        BtnPlus(
            onClick = { /*TODO*/ }, text = R.string.agregar,
            color = MaterialTheme.colorScheme.secondary, textColor = Color.White
        )
    }
}
