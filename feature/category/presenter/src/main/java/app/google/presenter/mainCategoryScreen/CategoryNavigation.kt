package app.google.presenter.mainCategoryScreen

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.google.presenter.categoryScreen.CategoryScreen
import app.google.presenter.categoryScreen.CategoryViewModel


object Routes {
    const val CATEGORY = "categoryScreen"
}


@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigateToDetail: (String) -> Unit = {}
) {
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
                    navigateToDetail(categoryId)
                }
            )
        }

    }
}
