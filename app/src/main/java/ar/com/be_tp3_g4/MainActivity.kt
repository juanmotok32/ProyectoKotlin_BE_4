package ar.com.be_tp3_g4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.com.be_tp3_g4.navigation.AppNavigation
import ar.com.be_tp3_g4.repository.UserRepositoryImp
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import ar.com.be_tp3_g4.ui.theme.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userRepository = UserRepositoryImp()

        setContent {
            val themeViewModel: ThemeViewModel = viewModel()
            BE_TP3_G4Theme(darkTheme = themeViewModel.isDarkTheme) {
                Surface(color = MaterialTheme.colorScheme.primary) {
                    AppNavigation(userRepository,themeViewModel)
                }
            }
        }
    }
}


