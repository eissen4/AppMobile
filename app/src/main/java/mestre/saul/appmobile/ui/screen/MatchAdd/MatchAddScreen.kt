package mestre.saul.appmobile.ui.screen.MatchAdd

import android.widget.CalendarView
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import mestre.saul.appmobile.data.model.MatchModel
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.ui.screen.Match.MatchItem
import mestre.saul.appmobile.ui.screen.Match.MatchViewModel
import mestre.saul.appmobile.ui.screen.team.TeamViewModel
import mestre.saul.appmobile.ui.view.Drawer
import mestre.saul.appmobile.ui.view.TopBar

@Composable
fun MatchAddScreen(navController: NavController) {
    val teamViewModel = TeamViewModel()
    val matchAddViewModel = MatchAddViewModel()

    var match = MatchModel("", "", 0, 0, "")

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
    topBar = { TopBar(barText = "MatchAddScreen", scope = scope, scaffoldState = scaffoldState) },
    drawerGesturesEnabled = true,
    drawerContent = {
        Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
    },
    scaffoldState = scaffoldState
    ) {
        Column() {

            teamViewModel.getTeamsList()
            val teams = teamViewModel.teams

            var expanded by rememberSaveable {
                mutableStateOf(false)
            }
            var selectedItem by rememberSaveable {
                mutableStateOf("")
            }
            var selectedItemId by rememberSaveable {
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
                            selectedItemId = label._id
                        }) {
                            Text(text = label.name)
                        }
                    }
                }
                var opponent by rememberSaveable {
                    mutableStateOf("")
                }
                TextField(value = opponent,
                    onValueChange = { opponent = it },
                    Modifier.padding(10.dp).align(CenterHorizontally),
                    label = { Text("Equipo contrario:") })
                var scoreOne by rememberSaveable {
                    mutableStateOf("")
                }
                TextField(value = scoreOne,
                    onValueChange = { scoreOne = it },
                    Modifier.padding(10.dp).align(CenterHorizontally),
                    label = { Text("Puntuación nuestro equipo:") })
                var scoreTwo by rememberSaveable {
                    mutableStateOf("")
                }
                TextField(value = scoreTwo,
                    onValueChange = { scoreTwo = it },
                    Modifier.padding(10.dp).align(CenterHorizontally),
                    label = { Text("Puntuación equipo contrario:") })
                var date by rememberSaveable {
                    mutableStateOf("")
                }
                AndroidView(factory = {CalendarView(it)}, update = {
                    it.setOnDateChangeListener{ calendarView, year, month, day ->
                       date = "$day/$month/$year"
                    }})
                Button(onClick = {
                    match.team = selectedItemId
                    match.opponent = opponent
                    match.date = date
                    match.scoreOne = scoreOne.toInt()
                    match.scoreTwo = scoreTwo.toInt()
                    matchAddViewModel.addMatch(match)
                    //navController.navigate("MatchScreen")
                                 },
                modifier = Modifier.align(CenterHorizontally)) {
                    Text(text = "Enviar")
                }
            }
        }
    }
}