package mestre.saul.appmobile.data.network

import mestre.saul.appmobile.data.model.PlayerModel
import mestre.saul.appmobile.data.model.TeamModel

class PlayerRepository {
    private val api = ApiService()

    suspend fun getAllPlayers(id: String): List<PlayerModel> {
        return api.getAllPlayers(id)
    }
}