package app.google.recipe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import app.google.presenter.SearchScreen
import app.google.presenter.SearchViewModel
import androidx.hilt.navigation.compose.hiltViewModel

object Routes {
    const val NAVIGATION_MAIL = "Mail"
    const val NAVIGATION_CATEGORY = "category"
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.NAVIGATION_CATEGORY) {
        composable(Routes.NAVIGATION_CATEGORY) {
            val loginViewModel: SearchViewModel = hiltViewModel()
            SearchScreen(loginViewModel)
        }
    }
}
