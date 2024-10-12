package ar.com.be_tp3_g4.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun TittleSub(@StringRes tittle: Int, @StringRes sub: Int) {
    Column {
        Text(
            text = stringResource(id = tittle),
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = sub),
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.displaySmall
        )
    }
}


@Preview
@Composable
fun TittleSubPreview() {
    BE_TP3_G4Theme {
        TittleSub(tittle = R.string.sign_up, sub = R.string.enter_email)
    }
}