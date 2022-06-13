package mestre.saul.appmobile.ui.screen.PlayerStat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mestre.saul.appmobile.data.model.PlayerStatModel

@Composable
fun PlayerStatItem(playerStat: PlayerStatModel){
    Card(
    ){
        Column(){
            Text(text = "Rival: " + playerStat.opponent)
            if (playerStat.date != null)
                Text(text = playerStat.date.toString())
            Row() {
                Text(text = "Puntos: "+ playerStat.points)
                Text(text = "Rebotes: "+ playerStat.rebounds)
                Text(text = "Asistencias: "+ playerStat.assists)
            }
        }
    }
}