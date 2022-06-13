package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.model.PlayerModel
import mestre.saul.appmobile.data.network.PlayerRepository

class GetPlayersUseCase() {
    private val repository = PlayerRepository()

    suspend operator fun invoke(id: String):List<PlayerModel>? = repository.getAllPlayers(id)
}