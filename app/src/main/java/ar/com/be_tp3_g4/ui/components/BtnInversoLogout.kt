import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun BtnInverso(onClick: () -> Unit, @StringRes text: Int, icon: Painter, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().padding(20.dp).height(67.dp),
        shape = RoundedCornerShape(19.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(stringResource(text), color = MaterialTheme.colorScheme.secondary)
        }
    }
}

@Preview
@Composable
fun logout() {
    BE_TP3_G4Theme {
        BtnInverso(
            onClick = { /*TODO*/ },
            text = R.string.logout,
            icon = painterResource(id = R.drawable.logout)
        )
    }
}
