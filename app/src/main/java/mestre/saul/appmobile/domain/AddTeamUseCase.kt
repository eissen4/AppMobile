package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.data.network.LoginRepository
import mestre.saul.appmobile.data.network.TeamRepository

class AddTeamUseCase {
    private val repository = TeamRepository()

    suspend operator fun invoke(team: TeamModel) = repository.addTeam(team)
}