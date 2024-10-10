package ar.com.be_tp3_g4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ar.com.be_tp3_g4.navigation.AppNavigation
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BE_TP3_G4Theme {
                AppNavigation()
            }
        }
    }
}


