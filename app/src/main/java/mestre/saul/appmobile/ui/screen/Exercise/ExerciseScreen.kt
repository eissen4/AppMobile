package mestre.saul.appmobile.ui.screen.Exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import mestre.saul.appmobile.ui.view.Drawer
import mestre.saul.appmobile.ui.view.TopBar

@Composable
fun ExerciseScreen(navController: NavController){
    val exerciseViewModel = ExerciseViewModel()
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
    ){
        Column() {
            val exercises = exerciseViewModel.exercises
            exerciseViewModel.getExercisesList()
            LazyColumn(){
                items(exercises){ exercise ->
                    ExerciseItem(exercise = exercise)
                }
            }
        }
    }
}