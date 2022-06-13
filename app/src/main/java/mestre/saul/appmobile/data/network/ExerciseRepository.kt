package mestre.saul.appmobile.data.network

import mestre.saul.appmobile.data.model.ExerciseModel
import mestre.saul.appmobile.data.model.TeamModel

class ExerciseRepository {
    private val api = ApiService()

    suspend fun getAllExercises(): List<ExerciseModel> {
        return api.getAllExercises()
    }
    suspend fun getWorldExercises(keys: String): List<ExerciseModel> {
        return api.getWorldExercises(keys)
    }
}