package ar.com.be_tp3_g4.ui.screens

import Desplegable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.data.Areas
import ar.com.be_tp3_g4.data.Lugares
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.TittleSub
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun SelectLocationScreen(goBack: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(15.dp))

        IconButton(onClick = { goBack() }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colorScheme.tertiary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        BackImg()

        Spacer(modifier = Modifier.height(30.dp))

        TittleSub(tittle = R.string.location_tittle, sub = R.string.location_subtittle)

        Spacer(modifier = Modifier.height(50.dp))

        Desplegable(label = R.string.zone, opciones = Lugares, placeholder = "")

        Desplegable(label = R.string.area, opciones = Areas, placeholder = "Types of your area")

        Spacer(modifier = Modifier.height(26.dp))

        Btn(
            onClick = { /*agregar logica para que guarde las cosas el vm y que navegue a home*/ },
            text = R.string.submit
        )
    }
}

@Composable
private fun BackImg() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.map_location),
            contentDescription = null,
            modifier = Modifier
                .size(220.dp)
                .align(Alignment.Center)
        )
    }
}


@Preview
@Composable
fun BackImgPreview() {
    BE_TP3_G4Theme {
        BackImg()
    }
}

@Preview
@Composable
fun SelectLocationScreenPreview() {
    BE_TP3_G4Theme {
        SelectLocationScreen(goBack = {})
    }
}