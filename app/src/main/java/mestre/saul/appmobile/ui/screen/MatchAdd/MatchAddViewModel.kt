package mestre.saul.appmobile.ui.screen.MatchAdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.data.model.MatchModel
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.domain.AddMatchUseCase
import mestre.saul.appmobile.domain.AddTeamUseCase

class MatchAddViewModel: ViewModel() {
    var addMatchUseCase = AddMatchUseCase()
    fun addMatch (match: MatchModel){
        viewModelScope.launch {
            addMatchUseCase(match)
        }
    }
}