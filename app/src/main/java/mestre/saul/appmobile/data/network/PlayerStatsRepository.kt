package mestre.saul.appmobile.data.network

import mestre.saul.appmobile.data.model.PlayerStatModel
import mestre.saul.appmobile.data.model.TeamModel

class PlayerStatsRepository {
    private val api = ApiService()

    suspend fun getPlayerStats(id: String): List<PlayerStatModel> {
        return api.getPlayerStats(id)
    }
}