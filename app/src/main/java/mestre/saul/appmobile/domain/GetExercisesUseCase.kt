package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.model.ExerciseModel
import mestre.saul.appmobile.data.model.TeamModel
import mestre.saul.appmobile.data.network.ExerciseRepository
import mestre.saul.appmobile.data.network.TeamRepository

class GetExercisesUseCase {
    private val repository = ExerciseRepository()

    suspend operator fun invoke():List<ExerciseModel>? = repository.getAllExercises()
}