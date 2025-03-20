package app.google.presenter.mainCategoryScreen

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.google.presenter.categoryScreen.CategoryViewModel
import app.google.presenter.categoryScreen.CategoryScreen
import app.google.presenter.detailCateogryScreen.CategoryMealScreen
import app.google.presenter.detailCateogryScreen.CategoryMealViewModel


object Routes {
    const val CATEGORY = "categoryScreen"
    const val DETAIL_CATEGORY = "detailCategory"
}

object Arguments {
    const val CATEGORY_ID = "categoryId"
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.CATEGORY,
        modifier = Modifier.background(Color.Transparent)
    ) {
        composable(route = Routes.CATEGORY) {
            val categoryViewModel: CategoryViewModel = hiltViewModel()
            CategoryScreen(
                viewModel = categoryViewModel,
                navigateToDetail = { categoryId ->
                    navController.navigateToDetail(categoryId)
                }
            )
        }

        composable(route = Routes.DETAIL_CATEGORY) {
            val categoryMealViewModel: CategoryMealViewModel = hiltViewModel()
            navController.previousBackStackEntry?.savedStateHandle?.get<String>(Arguments.CATEGORY_ID)?.let { categoryId ->
                CategoryMealScreen(
                    categoryMealViewModel = categoryMealViewModel,
                    categoryId = categoryId
                )
            }
        }
    }
}

private fun NavHostController.navigateToDetail(categoryId: String) {
    currentBackStackEntry?.savedStateHandle?.set(Arguments.CATEGORY_ID, categoryId)
    navigate(Routes.DETAIL_CATEGORY)
}

