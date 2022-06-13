package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.model.PlayerStatModel
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.data.network.PlayerStatsRepository
import mestre.saul.appmobile.data.network.TeamRepository

class GetPlayerStatsUseCase {
    private val repository = PlayerStatsRepository()

    suspend operator fun invoke(id: String):List<PlayerStatModel>? = repository.getPlayerStats(id)
}