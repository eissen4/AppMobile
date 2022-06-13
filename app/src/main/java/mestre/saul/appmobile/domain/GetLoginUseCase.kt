package mestre.saul.appmobile.domain

import mestre.saul.appmobile.data.network.LoginRepository

class GetLoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(username: String, password: String) = repository.login(username = username, password = password)
}