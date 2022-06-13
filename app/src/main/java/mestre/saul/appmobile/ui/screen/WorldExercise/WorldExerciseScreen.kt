package mestre.saul.appmobile.ui.screen.WorldExercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mestre.saul.appmobile.ui.screen.Exercise.ExerciseItem
import mestre.saul.appmobile.ui.view.Drawer
import mestre.saul.appmobile.ui.view.TopBar

@Composable
fun WorldExerciseScreen(navController: NavController){
    val worldExerciseViewModel = WorldExerciseViewModel()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { TopBar(barText = "TheWorld", scope = scope, scaffoldState = scaffoldState) },
        drawerGesturesEnabled = true,
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        scaffoldState = scaffoldState
    ){
        Column() {
            var keys by rememberSaveable {
                mutableStateOf("")
            }
            TextField(value = keys, onValueChange = {keys = it})
            Button(onClick = { worldExerciseViewModel.getWorldExercisesList(keys) }) {
                Text(text = "Buscar")
            }

        }
        val exercises = worldExerciseViewModel.worldExercises
        LazyColumn(modifier = Modifier.background(color = Color.Blue).padding(10.dp)){
            items(exercises){ exercise ->
                ExerciseItem(exercise = exercise)
            }
        }
    }
}