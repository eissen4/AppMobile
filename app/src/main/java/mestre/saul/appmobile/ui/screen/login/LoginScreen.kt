package mestre.saul.appmobile.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun LoginScreen(navController: NavController){
    var username by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val loginViewModel = LoginViewModel()
    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("http://192.168.31.93:3000/uploads/logoapp.png")
                .crossfade(2000)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )
        TextField(value = username,
            onValueChange = {username = it},
            Modifier.padding(10.dp)
                .align(Alignment.CenterHorizontally),
            label = { Text("Usuario") })
        TextField(
            value = password,
            onValueChange = { password = it },
            Modifier.padding(10.dp)
                .align(Alignment.CenterHorizontally),
            label = { Text("Contraseña") },
            singleLine = true,
            placeholder = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            }
        )
        Button(onClick = {
            loginViewModel.login(username = username, password = password)
            navController.navigate("MyTeam")
        },
            Modifier.padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
            Text(text = "Enviar")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("RegisterScreen")
        },
            Modifier.padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
            Text(text = "¿Todavía no te has registrado? ¡Hazlo! :)")
        }
    }
}
