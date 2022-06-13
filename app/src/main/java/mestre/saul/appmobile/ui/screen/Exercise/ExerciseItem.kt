package mestre.saul.appmobile.ui.screen.Exercise

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import mestre.saul.appmobile.data.model.ExerciseModel
import mestre.saul.appmobile.ui.screen.WorldExercise.WorldExerciseViewModel

@Composable
fun ExerciseItem(exercise: ExerciseModel){

    Card() {
        Column(modifier = Modifier.padding(10.dp)) {
            Row() {
               Box(modifier = Modifier
                   .fillMaxWidth()
                   .height(300.dp)
               ) {
                   AsyncImage(model = "https://as1.ftcdn.net/v2/jpg/04/14/41/52/1000_F_414415250_SSetMKFnyxAtHmfAyYcuI4xrhN6915gJ.jpg", contentDescription = null, modifier = Modifier
                       .height(500.dp)
                       .width(200.dp))
                   AsyncImage(model = "http://192.168.31.93:3000/uploads/" + exercise.imageUrl, contentDescription = null, modifier = Modifier
                       .height(500.dp)
                       .width(200.dp))
               }
            }
            Row() {
                Column() {
                    Text(text = "Título: " + exercise.title, modifier = Modifier.padding(10.dp))
                    Text(text = "Descripción: " + exercise.title, modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}