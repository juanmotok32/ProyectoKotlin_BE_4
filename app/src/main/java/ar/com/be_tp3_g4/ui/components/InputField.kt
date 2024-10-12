package ar.com.be_tp3_g4.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,          //va a ser la etiqueta que diga: nombre de fruta, precio, password.....
    isPassword: Boolean = false,     //al agregarle esto, me va a servir para mails, texto y passwords
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,  //para pasar opciones de teclado (avanzar, terminar, etc
    keyboardActions: KeyboardActions = KeyboardActions.Default,  //eso se lo puedo agregar para meterle una funcion del estilo "chequear que lo que escriba el usuario cumpla con tal cosa, validar, etc
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        //lo mismo que textfield, pero con un borde delineado
        value = value,  //aca le asigno a value lo que me escriba el usuario (su contra, email, lo que sea), o fruta
        onValueChange = onValueChange,  //llama a la funcion que actualiza el value
        label = { Text(text = stringResource(id = label), color = MaterialTheme.colorScheme.tertiary) },
        modifier = modifier.fillMaxWidth().height(78.55.dp), //esto conviene recibirlo por parametro, para que sea mas adaptable
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        //si es password, PasswordVisualTransformation() pone los *, sino no hay transforation, corta
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.primary,    //fondo cuando no escribo
            focusedContainerColor = MaterialTheme.colorScheme.primary,       //fondo escribiendo
            unfocusedIndicatorColor = MaterialTheme.colorScheme.tertiary, // Color del borde desenfocado
            focusedIndicatorColor = MaterialTheme.colorScheme.tertiary     // borde enfocado
        ),
        /*
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        Le puedo meter uin placeholder para que se vea algo antes de que el usuario escruiba
         */
    )
}

@Preview
@Composable
fun InputFieldPreview() {
    BE_TP3_G4Theme {
        InputField(value = "holis", onValueChange = {}, label = R.string.email)
    }
}
