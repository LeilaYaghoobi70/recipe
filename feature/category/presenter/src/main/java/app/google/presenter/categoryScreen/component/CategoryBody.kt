package app.google.presenter.categoryScreen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.google.model.SpecialCategory

@Composable
fun CategoryBody(
    modifier: Modifier = Modifier.fillMaxSize(),
    navigateToDetail: (String) -> Unit,
    getCategories: (String) -> Unit,
    categories: List<Pair<String, Boolean>>,
    specialCategories: List<SpecialCategory>,
    showCategoriesLoading: Boolean,
    showSpecialCategoryLoading: Boolean,
) {
    Column(modifier = modifier) {
        when {
            showCategoriesLoading -> CategoryShimmerView()
            else -> CategoryView(
                categories = categories,
                onCategoryClick = getCategories
            )
        }
        Spacer(Modifier.height(12.dp))
        when {
            showSpecialCategoryLoading -> SpecialCategoryShimmerView()
            else -> {
                SpecialCategoryView(
                    specialCategories = specialCategories,
                    navigateToDetail = navigateToDetail,
                )
            }
        }
    }
}