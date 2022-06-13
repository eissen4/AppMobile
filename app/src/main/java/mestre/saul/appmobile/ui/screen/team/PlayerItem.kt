package mestre.saul.appmobile.ui.screen.team

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import mestre.saul.appmobile.data.model.PlayerModel

@Composable
fun PlayerItem(player: PlayerModel, navController: NavController) {

    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.Blue,
        modifier = Modifier.padding(10.dp)

    ) {
        Row(modifier = Modifier.fillMaxWidth()){
            Column(){
                Text(text = "Nombre: " + player.name)
                Text(text = "Altura: " + player.height)
                Text(text = "Peso: " + player.weight)
            }
        }
    }
}