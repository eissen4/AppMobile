package mestre.saul.appmobile.ui.screen.Exercise

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.data.model.ExerciseModel
import mestre.saul.appmobile.domain.GetExercisesUseCase
import mestre.saul.appmobile.domain.GetTeamsUseCase

class ExerciseViewModel: ViewModel() {
    var exercises: List<ExerciseModel> by mutableStateOf(listOf())
    init{
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }
    fun getExercisesList(){
        viewModelScope.launch {
            val getExercisesUseCase = GetExercisesUseCase()
            exercises = getExercisesUseCase()?: emptyList()
        }
    }
}