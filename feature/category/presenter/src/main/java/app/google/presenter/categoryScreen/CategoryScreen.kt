package app.google.presenter.categoryScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.google.common.ui.theme.RecipeTheme
import app.google.presenter.categoryScreen.arch.CategoryEvent
import app.google.presenter.categoryScreen.component.CategoryBody
import app.google.presenter.categoryScreen.component.CategoryView
import app.google.presenter.categoryScreen.component.SpecialCategoryView

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel,
    navigateToDetail: (String) -> Unit
) {
    val viewModelState by viewModel.state.collectAsState()
    RecipeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Spacer(Modifier.height(12.dp))
            CategoryBody(
                getCategories = {
                    viewModel.handleEvent(CategoryEvent.GetSpecialCategory(it))
                },
                navigateToDetail = navigateToDetail,
                categories = viewModelState.categories,
                specialCategories = viewModelState.specialCategories,
                showCategoriesLoading = viewModelState.showCategoryLoading,
                showSpecialCategoryLoading = viewModelState.showSpecialCategoryLoading,
            )
        }
    }
}
