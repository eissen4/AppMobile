package mestre.saul.appmobile.data.network

import mestre.saul.appmobile.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface IApiClient {
    @POST("/login")
    suspend fun login(@Body auth: AuthModel): Response<TokenResponse>
    @GET("/team/getTeamPerToken/")
    suspend fun getAllTeams(): Response<List<TeamModel>>
    @GET("/team/getPlayersPerTeam/{id}")
    suspend fun getAllPlayers(@Path("id") id: String): Response<List<PlayerModel>>
    @GET("/statPlayerMatch/getAllStatsFromPlayer/{id}")
    suspend fun getPlayerStats(@Path("id") id: String): Response<List<PlayerStatModel>>
    @GET("/match/getAllMatchesFromTeam/{id}")
    suspend fun getAllMatches(@Path("id") id: String): Response<List<MatchModel>>
    @POST("/team")
    suspend fun addTeam(@Body auth: TeamModel)
    @GET("/exercise/")
    suspend fun getAllExercises(): Response<List<ExerciseModel>>
    @GET("/exercise/getExerciseSearched/{keys}")
    suspend fun getWorldExercises(@Path("keys") id: String): Response<List<ExerciseModel>>
    @POST("/match")
    suspend fun addMatch(@Body match: MatchModel)
}