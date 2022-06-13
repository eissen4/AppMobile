package mestre.saul.appmobile.ui.screen.Match

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.data.model.MatchModel
import mestre.saul.appmobile.data.model.PlayerModel
import mestre.saul.appmobile.domain.GetMatchesUseCase
import mestre.saul.appmobile.domain.GetPlayersUseCase
import mestre.saul.appmobile.domain.GetTeamsUseCase

class MatchViewModel: ViewModel() {
    var matches: List<MatchModel> by mutableStateOf(listOf())
    init{
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }
    fun getMatchesList(id: String){
        viewModelScope.launch {
            val getMatchesUseCase = GetMatchesUseCase()
            matches = getMatchesUseCase(id)?: emptyList()
        }
    }
}