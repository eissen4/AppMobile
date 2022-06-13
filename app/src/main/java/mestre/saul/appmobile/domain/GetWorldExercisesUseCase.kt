package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.model.ExerciseModel
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.data.network.ExerciseRepository
import mestre.saul.appmobile.data.network.TeamRepository

class GetWorldExercisesUseCase {
    private val repository = ExerciseRepository()

    suspend operator fun invoke(keys: String):List<ExerciseModel>? = repository.getWorldExercises(keys)
}