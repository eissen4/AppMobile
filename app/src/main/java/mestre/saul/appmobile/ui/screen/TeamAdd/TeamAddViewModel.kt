package mestre.saul.appmobile.ui.screen.TeamAdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.domain.AddTeamUseCase
import mestre.saul.appmobile.domain.GetLoginUseCase

class TeamAddViewModel: ViewModel() {
    var addTeamUseCase = AddTeamUseCase()
    fun addTeam (team: TeamModel){
        viewModelScope.launch {
            addTeamUseCase(team)
        }
    }
}