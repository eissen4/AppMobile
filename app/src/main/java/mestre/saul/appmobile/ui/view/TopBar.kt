package mestre.saul.appmobile.ui.view

import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import mestre.saul.appmobile.Navigation.DrawerNavigation
import okhttp3.internal.wait

@Composable
fun TopBar(barText: String, scope: CoroutineScope, scaffoldState: ScaffoldState){
    val context = LocalContext.current
    TopAppBar(
        backgroundColor = Color.Blue,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
               Column {
                   Text(
                       text = barText,
                       color = Color.Black,
                       fontSize = 25.sp
                   )
               }
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        contentColor = Color.White

    )
}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController){
    val items = listOf(
        DrawerNavigation.TeamScreen,
        DrawerNavigation.MatchScreen,
        DrawerNavigation.PlayerScreen,
        DrawerNavigation.ExerciseScreen,
        DrawerNavigation.WorldExerciseScreen
    )
    Column(
        modifier = Modifier.background(color = Color.Blue)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            DrawerItem(item, selected = currentRoute == item.route, onItemClick = {
                navController.navigate(item.route){
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route){
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch { scaffoldState.drawerState.close() }
            })
        }
    }
}

@Composable
fun DrawerItem(item: DrawerNavigation, selected: Boolean, onItemClick: (DrawerNavigation) -> Unit){
    val background = if(selected) Color.Blue else Color.Transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .background(background)
            .padding(start = 10.dp)
    ) {
        Image(
            imageVector = item.icon,
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.White),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = item.title,
            fontSize = 18.sp,
            color = Color.White)
    }
}