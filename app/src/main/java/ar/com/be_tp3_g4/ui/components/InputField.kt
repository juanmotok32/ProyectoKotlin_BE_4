package ar.com.be_tp3_g4.ui.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme

@Composable 
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,          //va a ser la etiqueta que diga: nombre de fruta, precio, password.....
    isPassword: Boolean = false,     //al agregarle esto, me va a servir para mails, texto y passwords
    modifier: Modifier = Modifier
) {
    OutlinedTextField(  //lo mismo que textfield, pero con un borde delineado
        value = value,  //aca le asigno a value lo que me escriba el usuario (su contra, email, lo que sea), o fruta
        onValueChange = onValueChange,  //llama a la funcion que actualiza el value
        label = { Text(label) },    //este label esta dentro del input, hasta que el usuario empiece a escribir. Esto: Text(label) crea un text y lo pone como label
        modifier = modifier, //esto conviene recibirlo por parametro, para que sea mas adaptable
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
        //si es password, PasswordVisualTransformation() pone los *, sino no hay transforation, corta
    )
}

@Preview
@Composable
fun InputFieldPreview(){
    BE_TP3_G4Theme {
        InputField(value = "holis", onValueChange = {}, label = "hola")
    }
}
