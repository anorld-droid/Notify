package com.ratham.notify


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ratham.notify.ui.home.DeanHome
import com.ratham.notify.ui.home.StudentHome
import com.ratham.notify.ui.signin.SignInContent
import kotlinx.coroutines.CoroutineScope


object MainDestinations {
    const val SIGIN_ROUTE ="signin/SignIn"
    const val STUDENT_HOME = "home/StudentHome"
    const val DEAN_HOME = "home/DeanHome"

}

@Composable
fun NotifyNavGraph(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = MainDestinations.SIGIN_ROUTE
    ) {

        composable(MainDestinations.SIGIN_ROUTE) {
            SignInContent(navController = navController)
        }

        composable(MainDestinations.STUDENT_HOME) {
            StudentHome(coroutineScope, scaffoldState = scaffoldState, navController = navController)
        }

        composable(MainDestinations.DEAN_HOME) {
            DeanHome(coroutineScope, scaffoldState = scaffoldState, navController = navController)
        }
    }
}

