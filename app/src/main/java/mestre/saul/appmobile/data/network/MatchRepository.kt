package mestre.saul.appmobile.data.network

import mestre.saul.appmobile.data.model.MatchModel
import mestre.saul.appmobile.data.model.PlayerModel
import mestre.saul.appmobile.data.model.TeamModel

class MatchRepository {
    private val api = ApiService()

    suspend fun getAllMatches(id: String): List<MatchModel> {
        return api.getAllMatches(id)
    }
    suspend fun addMatch(match: MatchModel) {
        return api.addMatch(match)
    }
}