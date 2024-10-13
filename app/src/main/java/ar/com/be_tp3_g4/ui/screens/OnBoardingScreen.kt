package ar.com.be_tp3_g4.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.helpers.WindowSizeHelper
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme


@Composable
private fun OnBoardingSection(
    getStarted: () -> Unit,
    modifier: Modifier = Modifier
) {  //aca le paso el modifier para acomodarlo dsps en protrait y landscape
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.zanahoria_logo),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "Welcome",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = "to our store",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = stringResource(id = R.string.onBoarding_subtittle),
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.displaySmall

        )
        Spacer(modifier = Modifier.padding(20.dp))
        Btn(onClick = getStarted, text = R.string.get_started)
    }
}

/*
@Preview()
@Composable
fun OnBoardingSectionPreview() {
    BE_TP3_G4Theme {
        OnBoardingSection(getStarted = {})
    }
}
 */

@Composable
private fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.back_img_edited),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop // Esto hace q la imagen ocupe toda la pantalla, junto con el fill maxsize
    )
}

/*
@Preview
@Composable
fun BackgroundImagePreview() {
    BE_TP3_G4Theme {
        BackgroundImage()
    }
}
 */


@Composable
private fun OnboardingScreenPortrait(getStarted: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundImage()
        OnBoardingSection(
            getStarted,
            modifier = Modifier
                .align(Alignment.BottomCenter) // Alinear al centro en la parte inferior
                .padding(start = 20.dp, end = 20.dp, bottom = 80.dp)
        )
    }
}



@Preview
@Composable
fun OnboardingScreenPreview() {
    BE_TP3_G4Theme {
        OnboardingScreenPortrait(getStarted = {})
    }
}


@Composable
fun OnboardingScreen(windowSizeHelper: WindowSizeHelper, getStarted: () -> Unit) {
    val windowSize = windowSizeHelper.getWindowSizeClass()

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            OnboardingScreenPortrait(getStarted)
        }

        WindowWidthSizeClass.Expanded -> {
            OnboardingScreenLandsCape(getStarted)
        }
    }
}

@Composable
private fun OnboardingScreenLandsCape(getStarted: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onSurface)
    ) {
        OnBoardingSection(
            getStarted = getStarted,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 200.dp, end = 200.dp)
        )
    }
}



