package mestre.saul.appmobile.ui.screen.Match

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import mestre.saul.appmobile.ui.screen.team.TeamViewModel
import mestre.saul.appmobile.ui.view.Drawer
import mestre.saul.appmobile.ui.view.TopBar

@Composable
fun MatchScreen (navController: NavController){
    val teamViewModel = TeamViewModel()
    val matchViewModel = MatchViewModel()

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { TopBar(barText = "MatchScreen", scope = scope, scaffoldState = scaffoldState) },
        drawerGesturesEnabled = true,
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        scaffoldState = scaffoldState,
        floatingActionButton = {
            IconButton(onClick = { navController.navigate("MatchAddScreen") },
                modifier = Modifier.background(color = Color.Blue)
            ) {
                Text(text = "+")
            }
        }
    ) {
        Column() {

            teamViewModel.getTeamsList()
            val teams = teamViewModel.teams
            val matches = matchViewModel.matches

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
                            matchViewModel.getMatchesList(label._id)
                        }) {
                            Text(text = label.name)
                        }
                    }
                }
                LazyColumn() {
                    items(matches) { match ->
                        Text(text = match.opponent)
                        MatchItem(match = match)
                    }
                }
            }
        }
    }
}