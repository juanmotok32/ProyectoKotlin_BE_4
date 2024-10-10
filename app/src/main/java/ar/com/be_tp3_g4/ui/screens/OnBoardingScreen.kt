package ar.com.be_tp3_g4.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun OnboardingScreen(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.back_img_edited),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Esto hace q la imagen ocupe toda la pantalla
        )
        Column(/*lo centro tutti en vertical y horizontal. dsps que ocupe el o.5 de la altura, y lo mando abajo con bottmcenter*/
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomCenter).padding(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.zanahoria_logo),
                contentDescription = null,
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Crop // Esto hace q la imagen ocupe toda la pantalla
            )
            Text(
                text = "Welcome",
                fontSize = 50.sp,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "to our store",
                fontSize = 50.sp,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Get your groceries in as fast as one hour",
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Btn(onClick = onClick, text = R.string.get_started)
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    BE_TP3_G4Theme {
        OnboardingScreen(onClick = {})
    }
}