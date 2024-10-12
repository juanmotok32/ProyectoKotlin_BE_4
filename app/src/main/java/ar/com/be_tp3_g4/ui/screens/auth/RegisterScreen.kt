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
fun RegisterScreen(
    authViewModel: AuthViewModel,
    signIn: () -> Unit,
    windowSizeHelper: WindowSizeHelper
) {
    val windowSize = windowSizeHelper.getWindowSizeClass()
    var paddingValue = 0.dp
    val scrollState = rememberScrollState()

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

        TittleSub(tittle = R.string.sign_up, sub = R.string.enter_credentials)

        Spacer(modifier = Modifier.height(30.dp))

        InputField(
            value = authViewModel.username, onValueChange = {}, label = R.string.username,
        )

        Spacer(modifier = Modifier.height(22.dp))

        InputField(
            value = authViewModel.email, onValueChange = {}, label = R.string.email,
        )

        Spacer(modifier = Modifier.height(22.dp))

        InputField(
            value = authViewModel.password, onValueChange = {}, label = R.string.password,
            isPassword = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

        //cambiar por parrafo
        Text(
            text = stringResource(id = R.string.forgot_password),
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.displaySmall,
        )

        Spacer(modifier = Modifier.height(22.dp))

        Btn(onClick = { /*authViewModel.onRegister*/ }, text = R.string.sign_up)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {   //IMPORTANTE! para centrar un elemento horizontamente, hagan que ocupe tod el ancho, sinoi se van a romper la cabeza 10 hs como yo
            Text(text = stringResource(id = R.string.has_account), color = MaterialTheme.colorScheme.inversePrimary)
            Text(
                text = "SingIn",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clickable { signIn() })
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    BE_TP3_G4Theme {
        RegisterScreen(
            authViewModel = AuthViewModel(),
            signIn = { /*TODO*/ },
            windowSizeHelper = WindowSizeHelper()
        )
    }
}
