package ar.com.be_tp3_g4.ui.screens.auth

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.helpers.WindowSizeHelper
import ar.com.be_tp3_g4.repository.UserRepositoryImp
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.InputField
import ar.com.be_tp3_g4.ui.components.LogoZanahoria
import ar.com.be_tp3_g4.ui.components.TittleSub
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun LoginScreen(
    userRepository: UserRepositoryImp,
    authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModel.AuthViewModelFactory(
            userRepository
        )
    ),
    signUp: () -> Unit,
    successLogin: () -> Unit,
    windowSizeHelper: WindowSizeHelper
) {
    val windowSize = windowSizeHelper.getWindowSizeClass()
    var paddingValue = 0.dp
    val scrollState = rememberScrollState() //para poder hacer scroll cuando rota la pantalla
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            paddingValue = 20.dp
        }

        WindowWidthSizeClass.Expanded -> {
            paddingValue = 200.dp
        }
    }

    val loginResult by authViewModel.loginResult.observeAsState()
    val username = authViewModel.username
    val password = authViewModel.password



        LaunchedEffect(loginResult) {
            loginResult?.let {
                if (it.isSuccess) {
                    // Si el login es exitoso, llama a successLogin
                    successLogin()
                } else {
                    // Puedes manejar el error aquí si es necesario
                    Log.e("LoginScreen", "${it.errorMessage}")

                    // Usar un mensaje de error por defecto si it.errorMessage es nulo
                    val message =
                        it.errorMessage
                            ?: "Ocurrió un error inesperado. Por favor, inténtalo de nuevo."
                    errorMessage = message
                }
            }
        }

        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },  containerColor = MaterialTheme.colorScheme.primary
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = paddingValue, end = paddingValue, bottom = 30.dp
                    )
                    .padding(innerPadding).padding(0.dp)
                    .verticalScroll(scrollState)
            ) {
                LogoZanahoria()
                TittleSub(tittle = R.string.sign_in, sub = R.string.enter_email)
                Spacer(modifier = Modifier.height(30.dp))

                InputField(
                    value = username,
                    onValueChange = { authViewModel.onUsernameChange(it) },
                    label = R.string.username,
                )
                Spacer(modifier = Modifier.height(22.dp))

                InputField(
                    value = password,
                    onValueChange = { authViewModel.onPasswordChange(it) },
                    label = R.string.password,
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

                Btn(
                    onClick = {
                        authViewModel.login(
                            authViewModel.username,
                            authViewModel.password
                        )
                    },
                    text = R.string.log_in
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.no_acount),
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                    Text(
                        text = "SingUp",
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.clickable { signUp() })
                }

                // Mostrar el Snackbar si hay un mensaje de error
                errorMessage?.let { message ->
                    Snackbar(
                        action = {
                            // Botón de acción para el Snackbar, puedes personalizarlo
                            Button(onClick = { errorMessage = null }) {
                                Text("Cerrar")
                            }
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = message)
                    }
                }
            }
        }
    }



@Preview
@Composable
fun LoginScreenPreview() {
    BE_TP3_G4Theme {
        val userRepository = UserRepositoryImp()
        LoginScreen(
            userRepository = userRepository,
            authViewModel = AuthViewModel(userRepository = userRepository),
            signUp = {},
            windowSizeHelper = WindowSizeHelper(),
            successLogin = {}
        )
    }
}



