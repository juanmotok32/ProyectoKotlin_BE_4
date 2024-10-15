package ar.com.be_tp3_g4.ui.components

import BtnInverso
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme


@Composable
fun OrderAccepted(showPopup: Boolean = false, onDismiss: () -> Unit, goToHome: ()->Unit={} ) {
    AnimatedVisibility(
        visible = showPopup, enter = fadeIn(),  // Animación de entrada
        exit = fadeOut()   // Animación de salida
    ) {
        Dialog(
            onDismissRequest = onDismiss,//FUNCION PARA CERRAR EL DIALOG
            properties = DialogProperties(dismissOnClickOutside = false) // Evita que se cierre al hacer clic afuera
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 8.dp

            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.acceptedimage),
                        contentDescription = "errorimage",
                        modifier = Modifier
                            .size(220.dp)
                            .padding(10.dp)
                            .weight(4f)
                    )
                    Text(
                        text = stringResource(id = R.string.order_accepted),
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.tertiary

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = R.string.order_accepted_2),
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(
                        modifier = Modifier
                            .height(16.dp)
                            .weight(1f)
                    )
                    Btn(
                        onClick = { onDismiss() },
                        text = R.string.track_order
                    ) //actualmente cierra el dialog porque no se implementa el track

                    Btn(onClick = {onDismiss()
                        goToHome()},
                        text = R.string.back_to_home)


                }

            }
        }

    }
}

@Composable
@Preview

fun testAnimetedPopUp() {

    BE_TP3_G4Theme {
        OrderAccepted(true, onDismiss = {})

    }
}
