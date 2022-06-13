package mestre.saul.appmobile.ui.screen.Match

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mestre.saul.appmobile.data.model.MatchModel

@Composable
fun MatchItem(match: MatchModel) {
    Column() {
        Row() {
            Text(text = "Resultado:" +match.opponent)
            Text(text = "")
        }
        Row() {
            
        }
    }
}