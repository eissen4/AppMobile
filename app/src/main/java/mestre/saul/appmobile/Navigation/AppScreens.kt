package mestre.saul.appmobile.Navigation

sealed class AppScreens(val route: String) {
    object LoginScreen: AppScreens("LoginScreen")
    object TeamScreen: AppScreens("MyTeam")
    object PlayerStatScreen: AppScreens("PlayerStatScreen")
    object TeamAddScreen: AppScreens("TeamAddScreen")
    object PlayerAddScreen: AppScreens("PlayerAddScreen")
    object MatchScreen: AppScreens("MyMatches")
    object MatchAddScreen: AppScreens("MatchAddScreen")
    object RegisterScreen: AppScreens("RegisterScreen")
    object ExerciseScreen: AppScreens("ExerciseScreen")
    object WorldExerciseScreen: AppScreens("WorldExerciseScreen")

    //El resto de pantallas igual
}