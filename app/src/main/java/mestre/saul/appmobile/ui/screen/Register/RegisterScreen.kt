package mestre.saul.appmobile.ui.screen.Register

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun RegisterScreen(navController: NavController){
    var username by rememberSaveable {
        mutableStateOf("")
    }
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Box(){

        Column() {
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
                label = { Text("Alias de usuario") })
            TextField(value = name,
                onValueChange = {name = it},
                Modifier.padding(10.dp)
                    .align(Alignment.CenterHorizontally),
                label = { Text("Nombre de usuario") })
            TextField(value = email,
                onValueChange = {email = it},
                Modifier.padding(10.dp)
                    .align(Alignment.CenterHorizontally),
                label = { Text("Email de usuario") })
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
                navController.navigate("LoginScreen")
            },
                Modifier.padding(10.dp)
                    .align(Alignment.CenterHorizontally)) {
                Text(text = "Enviar")
            }
            Button(onClick = {
                navController.navigate("LoginScreen")
            },
                Modifier.padding(10.dp)
                    .align(Alignment.CenterHorizontally)){
                Text(text = "(Vuelve al Login)")
            }
        }
    }
}