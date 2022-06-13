package mestre.saul.appmobile.ui.screen.TeamAdd

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.ui.view.Drawer
import mestre.saul.appmobile.ui.view.TopBar

@Composable
fun TeamAddScreen(navController: NavController){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val teamAddViewModel = TeamAddViewModel()
    var team = TeamModel("", "")
    Scaffold(
        topBar = { TopBar(barText = "TeamScreen", scope = scope, scaffoldState = scaffoldState) },
        drawerGesturesEnabled = true,
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        scaffoldState = scaffoldState
    ) {
        Column() {
            var username by rememberSaveable {
                mutableStateOf("")
            }
            TextField(value = username,
                onValueChange = { username = it },
                Modifier.padding(10.dp),
                label = { Text("Equipo nuevo:") })
            Button(onClick = {
                team.name = username
                teamAddViewModel.addTeam(team = team)
            }) {
                Text(text = "Enviar")
            }
        }
    }
}