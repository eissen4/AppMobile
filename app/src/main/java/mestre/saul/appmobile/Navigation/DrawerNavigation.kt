package mestre.saul.appmobile.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerNavigation(var route: String, var icon: ImageVector, var title: String){
    object TeamScreen: DrawerNavigation(AppScreens.TeamScreen.route, Icons.Filled.AccountBox, "MyTeam")
    object MatchScreen: DrawerNavigation(AppScreens.MatchScreen.route, Icons.Filled.AccountBox, "MyMatches")
    object PlayerScreen: DrawerNavigation(AppScreens.PlayerStatScreen.route, Icons.Filled.AccountBox, "MyPlayers")
    object ExerciseScreen: DrawerNavigation(AppScreens.ExerciseScreen.route, Icons.Filled.AccountBox, "MyExercises")
    object WorldExerciseScreen: DrawerNavigation(AppScreens.WorldExerciseScreen.route, Icons.Filled.AccountBox, "TheWorld")
}