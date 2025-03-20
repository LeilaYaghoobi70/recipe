package app.google.recipe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.hilt.navigation.compose.hiltViewModel
import app.google.presenter.MealScreen
import app.google.presenter.MealViewModel
import app.google.presenter.mainCategoryScreen.MainScreen

object Routes {
    const val NAVIGATION_TO_MAIL = "Mail"
    const val NAVIGATION_CATEGORY = "category"
}

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.NAVIGATION_CATEGORY) {
        composable(Routes.NAVIGATION_CATEGORY) {
            MainScreen(navigateToMail = {
                navHostController.navigateToMail()
            })
        }
        composable(Routes.NAVIGATION_TO_MAIL) {
           val mealViewModel: MealViewModel = hiltViewModel()
            MealScreen(mealViewModel = mealViewModel)
        }
    }
}

fun NavHostController.navigateToMail() {
    navigate(Routes.NAVIGATION_TO_MAIL)
}


