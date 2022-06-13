package mestre.saul.appmobile.data.network

import mestre.saul.appmobile.data.model.TeamModel

class TeamRepository {
    private val api = ApiService()

    suspend fun getAllTeams(): List<TeamModel> {
        return api.getAllTeams()
    }
    suspend fun addTeam(team: TeamModel) {
        return api.addTeam(team)
    }
}