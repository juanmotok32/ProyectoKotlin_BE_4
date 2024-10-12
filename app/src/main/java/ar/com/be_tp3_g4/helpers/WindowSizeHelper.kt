package ar.com.be_tp3_g4.helpers

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass


//clase para calcular el tamaño del disposivo, para elegir entre portrait (vertical) o laqndscape (horizontal)
class WindowSizeHelper {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)  /*esto quiere decir que es experimental y puede dar error*/
    @Composable
    fun getWindowSizeClass(): WindowSizeClass {
        val context = LocalContext.current
        /* LocalContex.current = Dame el contexto que está disponible ahora mismo, aquí donde estoy componiendo esta clase
        el contexto me sirve para acceder a cosas de la app (investigar mas)
        segun chat: nombvre de la app, imagenes, colores de la screen, mandar mnsjs de error, etc
        */
        val activity = context as ComponentActivity
        /*
        esto es una conversion del context de arriba a component activity. grecias a esto, puedo acceder a ciertas cosas
        que desde "context directamente no me deja, como el calculo del tamaño de la ventana, qiue es lo que necesito
        */
        return calculateWindowSizeClass(activity) //calcula el tamaño de la ventana (compacto-medio-alto) en ancho y largo del celu
    }
}