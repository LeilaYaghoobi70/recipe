package app.google.recipe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import app.google.presenter.mainCategoryScreen.MainCategoryScreen
import app.google.presenter.mainMealScreen.MainMealScreen


object Routes {
    const val CATEGORY = "category"
    const val MEAL = "meal/{mealId}"
}

object Arguments {
    const val MEAL_ID = "mealId"
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.CATEGORY) {
        addCategoryScreen(navController)
        addMealScreen()
    }
}


private fun NavGraphBuilder.addCategoryScreen(navController: NavHostController) {
    composable(route = Routes.CATEGORY) {
        MainCategoryScreen(
            navigateToMail = { mealId ->
                navController.navigate("meal/$mealId")
            }
        )
    }
}

private fun NavGraphBuilder.addMealScreen() {
    composable(
        route = Routes.MEAL,
        arguments = listOf(navArgument(Arguments.MEAL_ID) { type = NavType.StringType })
    ) { backStackEntry ->
        val mealId = backStackEntry.arguments?.getString(Arguments.MEAL_ID) ?: ""
        MainMealScreen(mealId)
    }
}
