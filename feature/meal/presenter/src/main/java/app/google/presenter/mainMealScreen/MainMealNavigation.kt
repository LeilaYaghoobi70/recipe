package app.google.presenter.mainMealScreen

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import app.google.presenter.meal.MealScreen
import app.google.presenter.meal.MealViewModel
import app.google.presenter.search.SearchScreen
import app.google.presenter.search.SearchViewModel

object Routes {
    const val SEARCH = "search"
    const val MEAL = "meal/{mealId}"
}

object Arguments {
    const val MEAL_ID = "mealId"
}


@Composable
fun AppNavGraph(
    navController: NavHostController,
    mealId: String
) {

    NavHost(
        navController = navController,
        startDestination = getStartDestination(mealId),
        modifier = Modifier.background(Color.Transparent),
    ) {
        addSearchScreen(navController = navController)
        addMealScreen()
    }
}



private fun getStartDestination(mealId: String) =
    if (mealId.isEmpty()) Routes.SEARCH else "meal/$mealId"


private fun NavGraphBuilder.addSearchScreen(navController: NavHostController) {
    composable(route = Routes.SEARCH) {
        val searchViewModel: SearchViewModel = hiltViewModel()
        SearchScreen(
            searchViewModel = searchViewModel,
            navigateToMeal = { id -> navController.navigate("meal/$id") }
        )
    }
}

private fun NavGraphBuilder.addMealScreen() {
    composable(
        route = Routes.MEAL,
        arguments = listOf(navArgument(Arguments.MEAL_ID) { type = NavType.StringType })
    ) { backStackEntry ->
        val mealViewModel: MealViewModel = hiltViewModel()
        val mealId = backStackEntry.arguments?.getString(Arguments.MEAL_ID) ?: ""
        MealScreen(mealViewModel = mealViewModel, categoryId = mealId)
    }
}

