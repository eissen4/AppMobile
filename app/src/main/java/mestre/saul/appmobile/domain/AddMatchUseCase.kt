package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.model.MatchModel
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.data.network.MatchRepository
import mestre.saul.appmobile.data.network.TeamRepository

class AddMatchUseCase {
    private val repository = MatchRepository()

    suspend operator fun invoke(match: MatchModel) = repository.addMatch(match)
}