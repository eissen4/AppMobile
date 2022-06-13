package mestre.saul.appmobile.data.network

import android.util.Log
import mestre.saul.appmobile.core.RetrofitHelper
import mestre.saul.appmobile.data.model.*
import retrofit2.Response

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun login(username: String, password: String) {
        val response = retrofit.create(IApiClient::class.java).login(AuthModel(username = username, password = password))
        Log.i("token", response.body().toString())
        val token = response.body()?.token!!
        Token.token = token
    }
    suspend fun getAllTeams():List<TeamModel>{
        val response: Response<List<TeamModel>> = retrofit.create(IApiClient::class.java).getAllTeams()
        return response.body() ?: emptyList()
    }
    suspend fun getAllPlayers(id: String):List<PlayerModel>{
        val response: Response<List<PlayerModel>> = retrofit.create(IApiClient::class.java).getAllPlayers(id)
        return response.body() ?: emptyList()
    }
    suspend fun getPlayerStats(id: String):List<PlayerStatModel>{
        val response: Response<List<PlayerStatModel>> = retrofit.create(IApiClient::class.java).getPlayerStats(id)
        return response.body() ?: emptyList()
    }
    suspend fun getAllMatches(id: String):List<MatchModel>{
        val response: Response<List<MatchModel>> = retrofit.create(IApiClient::class.java).getAllMatches(id)
        return response.body() ?: emptyList()
    }
    suspend fun addTeam(team: TeamModel) {
        val response = retrofit.create(IApiClient::class.java).addTeam(team)
    }
    suspend fun getAllExercises():List<ExerciseModel>{
        val response: Response<List<ExerciseModel>> = retrofit.create(IApiClient::class.java).getAllExercises()
        return response.body() ?: emptyList()
    }
    suspend fun getWorldExercises(keys: String):List<ExerciseModel>{
        val response: Response<List<ExerciseModel>> = retrofit.create(IApiClient::class.java).getWorldExercises(keys)
        return response.body() ?: emptyList()
    }
    suspend fun addMatch(match: MatchModel) {
        val response = retrofit.create(IApiClient::class.java).addMatch(match)
    }
}