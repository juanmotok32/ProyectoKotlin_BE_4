package ar.com.be_tp3_g4.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun ErrorDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        Dialog(
            onDismissRequest = onDismiss, //FUNCION PARA CERRAR EL DIALOG
            properties = DialogProperties(dismissOnClickOutside = false) // Evita que se cierre al hacer clic afuera
        ) {
            Surface(
                modifier = Modifier
                    .height(601.dp)
                    .width(364.dp),
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 8.dp

            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Text(text = "X", Modifier.clickable {onDismiss()},
                            color = MaterialTheme.colorScheme.tertiary)

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.errorimage),
                            contentDescription = "errorimage",
                            modifier = Modifier
                                .size(220.dp)
                                .padding(10.dp)
                                .weight(4f)
                        )
                        Text(
                            text = stringResource(id = R.string.order_fail),
                            style = MaterialTheme.typography.headlineLarge,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.tertiary

                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = stringResource(id = R.string.something_wrong),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f),
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                                .weight(1f)
                        )
                        /*Button(onClick = { onDismiss() },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary
                            )){
                        }*/
                        Btn(onClick = {onDismiss()}, text = R.string.please_try_again)

                        Btn(onClick = {/*NAVIGATE_HOME_FUN*/}, text = R.string.back_to_home)  //CAMBIAR POR BOTON BLANCO

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ErrorScreen() {
    BE_TP3_G4Theme {
        var showError by remember { mutableStateOf(true) }  // Controla si se muestra el diálogo o no

        ErrorDialog(
            showDialog = showError,
            onDismiss = { showError = false },  // Acción al cerrar el modal
        )

    }

}
