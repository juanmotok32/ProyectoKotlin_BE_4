package ar.com.be_tp3_g4.ui.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.helpers.WindowSizeHelper
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.InputField
import ar.com.be_tp3_g4.ui.components.LogoZanahoria
import ar.com.be_tp3_g4.ui.components.TittleSub

import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    signUp: () -> Unit,
    windowSizeHelper: WindowSizeHelper
) {
    val windowSize = windowSizeHelper.getWindowSizeClass()
    var paddingValue = 0.dp
    val scrollState = rememberScrollState() //para poder hacer scroll cuando rota la pantalla

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            paddingValue = 20.dp
        }

        WindowWidthSizeClass.Expanded -> {
            paddingValue = 200.dp
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = paddingValue, end = paddingValue, bottom = 30.dp
            )
            .verticalScroll(scrollState)
    ) {
        LogoZanahoria()

        TittleSub(tittle = R.string.sign_in, sub = R.string.enter_email)

        Spacer(modifier = Modifier.height(30.dp))

        InputField(
            value = authViewModel.email, onValueChange = {}, label = R.string.email,
        )

        Spacer(modifier = Modifier.height(22.dp))

        InputField(
            value = authViewModel.password, onValueChange = {}, label = R.string.password,
            isPassword = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.forgot_password),
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(22.dp))

        Btn(onClick = { /*authViewModel.onLoginSuccess*/ }, text = R.string.log_in)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {   //IMPORTANTE! para centrar un elemento horizontamente, hagan que ocupe tod el ancho, sinoi se van a romper la cabeza 10 hs como yo
            Text(text = stringResource(id = R.string.no_acount), color = MaterialTheme.colorScheme.inversePrimary)
            Text(
                text = "SingUp",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clickable { signUp() })
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    BE_TP3_G4Theme {
        LoginScreen(
            authViewModel = AuthViewModel(),
            signUp = {},
            windowSizeHelper = WindowSizeHelper()
        )
    }
}



