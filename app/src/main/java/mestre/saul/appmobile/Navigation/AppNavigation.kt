package mestre.saul.appmobile.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mestre.saul.appmobile.ui.screen.Exercise.ExerciseScreen
import mestre.saul.appmobile.ui.screen.login.LoginScreen
import mestre.saul.appmobile.ui.screen.Match.MatchScreen
import mestre.saul.appmobile.ui.screen.MatchAdd.MatchAddScreen
import mestre.saul.appmobile.ui.screen.PlayerStat.PlayerStatScreen
import mestre.saul.appmobile.ui.screen.Register.RegisterScreen
import mestre.saul.appmobile.ui.screen.team.TeamScreen
import mestre.saul.appmobile.ui.screen.TeamAdd.TeamAddScreen
import mestre.saul.appmobile.ui.screen.WorldExercise.WorldExerciseScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route ){
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.TeamScreen.route) {
            TeamScreen(navController)
        }
        composable(route = AppScreens.MatchScreen.route) {
            MatchScreen(navController)
        }
        composable(route = AppScreens.PlayerStatScreen.route ) {
            PlayerStatScreen(navController = navController)
        }
        composable(route = AppScreens.TeamAddScreen.route) {
            TeamAddScreen(navController = navController)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = AppScreens.WorldExerciseScreen.route) {
            WorldExerciseScreen(navController = navController)
        }
        composable(route = AppScreens.ExerciseScreen.route) {
            ExerciseScreen(navController = navController)
        }
        composable(route = AppScreens.MatchAddScreen.route) {
            MatchAddScreen(navController = navController)
        }
    }
}