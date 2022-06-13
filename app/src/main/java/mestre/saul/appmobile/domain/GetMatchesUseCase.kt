package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.model.MatchModel
import mestre.saul.appmobile.data.model.PlayerModel
import mestre.saul.appmobile.data.network.MatchRepository
import mestre.saul.appmobile.data.network.PlayerRepository

class GetMatchesUseCase {
    private val repository = MatchRepository()

    suspend operator fun invoke(id: String):List<MatchModel>? = repository.getAllMatches(id)
}