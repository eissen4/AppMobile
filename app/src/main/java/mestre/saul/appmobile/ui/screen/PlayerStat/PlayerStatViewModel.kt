package mestre.saul.appmobile.ui.screen.PlayerStat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.data.model.PlayerModel
import mestre.saul.appmobile.data.model.PlayerStatModel
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.domain.GetPlayerStatsUseCase
import mestre.saul.appmobile.domain.GetTeamsUseCase

class PlayerStatViewModel: ViewModel() {
    var playerStats by  mutableStateOf(listOf<PlayerStatModel>())

    init{
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }
    fun getPlayerStatsList(id: String){
        viewModelScope.launch {
            val getPlayerStatsUseCase = GetPlayerStatsUseCase()
            playerStats = getPlayerStatsUseCase(id)?: emptyList()
        }
    }
}