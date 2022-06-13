package mestre.saul.appmobile.ui.screen.PlayerStat

import android.util.Log
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
import mestre.saul.appmobile.data.model.Token
import mestre.saul.appmobile.ui.screen.team.PlayerItem
import mestre.saul.appmobile.ui.screen.team.TeamViewModel
import mestre.saul.appmobile.ui.view.Drawer
import mestre.saul.appmobile.ui.view.TopBar

@Composable
fun PlayerStatScreen(navController: NavController){
    val teamViewModel = TeamViewModel()
    val playerStatViewModel = PlayerStatViewModel()

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { TopBar(barText = "MyPlayers", scope = scope, scaffoldState = scaffoldState) },
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
    ) {
        Column() {

            teamViewModel.getTeamsList()
            val teams = teamViewModel.teams
            val players = teamViewModel.players
            val playerStats = playerStatViewModel.playerStats

            var expandedTeam by rememberSaveable {
                mutableStateOf(false)
            }
            var selectedItemTeam by rememberSaveable {
                mutableStateOf("")
            }

            var textFiledSizeTeam by remember {
                mutableStateOf(Size.Zero)
            }

            val icon = if (expandedTeam) {
                Icons.Filled.KeyboardArrowUp
            } else {
                Icons.Filled.KeyboardArrowDown
            }

            Column(modifier = Modifier.padding(20.dp)) {
                OutlinedTextField(value = selectedItemTeam, onValueChange = { selectedItemTeam = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            textFiledSizeTeam = coordinates.size.toSize()
                        },
                    label = { Text(text = "Elige un equipo") },
                    trailingIcon = {
                        Icon(icon, "", Modifier.clickable { expandedTeam = !expandedTeam })
                    })
                DropdownMenu(
                    expanded = expandedTeam,
                    onDismissRequest = { expandedTeam },
                    modifier = Modifier.width(with(LocalDensity.current) { textFiledSizeTeam.width.toDp() })
                ) {
                    teams.forEach() { label ->
                        DropdownMenuItem(onClick = {
                            selectedItemTeam = label.name
                            expandedTeam = false
                            teamViewModel.getPlayersList(label._id)
                        }) {
                            Text(text = label.name)
                        }
                    }
                }
                var expandedPlayer by rememberSaveable {
                    mutableStateOf(false)
                }
                var selectedItemPlayer by rememberSaveable {
                    mutableStateOf("")
                }

                var textFiledSizePlayer by remember {
                    mutableStateOf(Size.Zero)
                }

                val icon = if (expandedPlayer) {
                    Icons.Filled.KeyboardArrowUp
                } else {
                    Icons.Filled.KeyboardArrowDown
                }
                Column(modifier = Modifier.padding(20.dp)) {
                    OutlinedTextField(value = selectedItemPlayer,
                        onValueChange = { selectedItemPlayer = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                textFiledSizePlayer = coordinates.size.toSize()
                            },
                        label = { Text(text = "Elige un jugador") },
                        trailingIcon = {
                            Icon(icon, "", Modifier.clickable { expandedPlayer = !expandedPlayer })
                        })
                    DropdownMenu(
                        expanded = expandedPlayer,
                        onDismissRequest = { expandedPlayer },
                        modifier = Modifier.width(with(LocalDensity.current) { textFiledSizePlayer.width.toDp() })
                    ) {
                        players.forEach() { label ->
                            DropdownMenuItem(onClick = {
                                selectedItemPlayer = label.name
                                expandedPlayer = false
                                playerStatViewModel.getPlayerStatsList(label._id)
                            }) {
                                Text(text = label.name)
                            }
                        }
                    }
                }
                LazyColumn() {
                    items(playerStats) { playerStat ->
                        PlayerStatItem(playerStat = playerStat)
                    }
                }
            }
        }
    }
}