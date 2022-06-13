package mestre.saul.appmobile.data.model

data class ExerciseModel (
    var _id: String,
    var user: String,
    var title: String,
    var imageUrl: String,
    var description: String,
    var value: List<String>
)