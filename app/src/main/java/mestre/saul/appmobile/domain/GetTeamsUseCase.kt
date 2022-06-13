package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.data.network.TeamRepository

class GetTeamsUseCase {
    private val repository = TeamRepository()

    suspend operator fun invoke():List<TeamModel>? = repository.getAllTeams()
}