package mestre.saul.appmobile.data.model

import java.util.*

data class PlayerStatModel(
    var player: String,
    var playerName: String,
    var team: String,
    var match: String,
    var opponent: String,
    var date: Date,
    var points: Int,
    var rebounds: Int,
    var assists: Int,
)
