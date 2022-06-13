package mestre.saul.appmobile.ui.screen.team

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.data.model.PlayerModel
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.domain.GetPlayersUseCase
import mestre.saul.appmobile.domain.GetTeamsUseCase

class TeamViewModel: ViewModel() {
    var teams: List<TeamModel> by mutableStateOf(listOf())
    var players: List<PlayerModel> by mutableStateOf(listOf())
    init{
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }
    fun getTeamsList(){
        viewModelScope.launch {
            val getTeamsUseCase = GetTeamsUseCase()
            teams = getTeamsUseCase()?: emptyList()
        }
    }
    fun getPlayersList(id: String){
        viewModelScope.launch {
            val getPlayersUseCase = GetPlayersUseCase()
            players = getPlayersUseCase(id)?: emptyList()
        }
    }
}