package mestre.saul.appmobile.data.network

class LoginRepository {
    private val api = ApiService()

    suspend fun login(username: String, password: String) {
        return api.login(username = username, password = password)
    }
}