package mestre.saul.appmobile.ui.screen.PlayerAdd

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mestre.saul.appmobile.ui.view.Drawer
import mestre.saul.appmobile.ui.view.TopBar

@Composable
fun PlayerAddScreen (navController: NavController) {
    var name by rememberSaveable {
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { TopBar(barText = "MyExercises", scope = scope, scaffoldState = scaffoldState) },
        drawerGesturesEnabled = true,
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        scaffoldState = scaffoldState,
        floatingActionButton = {
            IconButton(onClick = {  },
                modifier = Modifier.background(color = Color.Blue)
            ) {
                Text(text = "+")
            }
        }
    ){}
    TextField(value = name,
        onValueChange = {name = it},
        Modifier.padding(10.dp),
        label = { Text("Nombre") })
    var height by rememberSaveable {
        mutableStateOf("")
    }
    TextField(value = height,
        onValueChange = {height = it},
        Modifier.padding(10.dp),
        label = { Text("Altura") })
    var weight by rememberSaveable {
        mutableStateOf("")
    }
    TextField(value = weight,
        onValueChange = {weight = it},
        Modifier.padding(10.dp),
        label = { Text("Peso") })
    DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
        Text(text = "Equipo")
    }
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Enviar")
    }
}

