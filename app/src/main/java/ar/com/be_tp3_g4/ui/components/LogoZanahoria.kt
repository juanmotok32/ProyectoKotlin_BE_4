package ar.com.be_tp3_g4.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun LogoZanahoria() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.zanahoria_naranja),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun LogoZanahoriaPreview(){
    BE_TP3_G4Theme {
        LogoZanahoria()
    }
}