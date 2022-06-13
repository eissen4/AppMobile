package mestre.saul.appmobile.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.domain.GetLoginUseCase

class LoginViewModel: ViewModel() {
    var loginUseCase = GetLoginUseCase()
    fun login(username:String, password: String){
        viewModelScope.launch {
            loginUseCase(username, password)
        }
    }
}