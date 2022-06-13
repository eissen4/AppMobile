package mestre.saul.appmobile.ui.screen.team

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import mestre.saul.appmobile.data.model.Token
import mestre.saul.appmobile.ui.view.Drawer
import mestre.saul.appmobile.ui.view.TopBar

@Composable
fun TeamScreen(navController: NavController) {
    val teamViewModel = TeamViewModel()

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { TopBar(barText = "MyTeam", scope = scope, scaffoldState = scaffoldState) },
        drawerGesturesEnabled = true,
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        scaffoldState = scaffoldState,
        floatingActionButton = {
            IconButton(onClick = { navController.navigate("TeamAddScreen")},
                modifier = Modifier.background(color = Color.Blue)
            ) {
                Text(text = "+")
            }

        }
    ) {
        Column() {

            teamViewModel.getTeamsList()
            val teams = teamViewModel.teams
            val players = teamViewModel.players

            var expanded by rememberSaveable {
                mutableStateOf(false)
            }
            var selectedItem by rememberSaveable {
                mutableStateOf("")
            }

            var textFiledSize by remember {
                mutableStateOf(Size.Zero)
            }

            val icon = if (expanded) {
                Icons.Filled.KeyboardArrowUp
            } else {
                Icons.Filled.KeyboardArrowDown
            }

            Column(modifier = Modifier.padding(20.dp)) {
                OutlinedTextField(value = selectedItem, onValueChange = { selectedItem = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            textFiledSize = coordinates.size.toSize()
                        },
                    label = { Text(text = "Elige un equipo") },
                    trailingIcon = {
                        Icon(icon, "", Modifier.clickable { expanded = !expanded })
                    })
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded },
                    modifier = Modifier.width(with(LocalDensity.current) { textFiledSize.width.toDp() })
                ) {
                    teams.forEach() { label ->
                        DropdownMenuItem(onClick = {
                            selectedItem = label.name
                            expanded = false
                            teamViewModel.getPlayersList(label._id)
                        }) {
                            Text(text = label.name)
                        }
                    }
                }
                LazyColumn() {
                    items(players) { player ->
                        PlayerItem(player = player, navController = navController)
                    }
                }
            }
        }
    }
}