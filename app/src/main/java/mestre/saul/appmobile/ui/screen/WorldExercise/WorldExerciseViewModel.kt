package mestre.saul.appmobile.ui.screen.WorldExercise

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.data.model.ExerciseModel
import mestre.saul.appmobile.domain.GetExercisesUseCase
import mestre.saul.appmobile.domain.GetWorldExercisesUseCase

class WorldExerciseViewModel: ViewModel() {
    var worldExercises: List<ExerciseModel> by mutableStateOf(listOf())
    init{
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }
    fun getWorldExercisesList(keys: String){
        viewModelScope.launch {
            val getWorldExercisesUseCase = GetWorldExercisesUseCase()
            worldExercises = getWorldExercisesUseCase(keys)?: emptyList()
        }
    }
}