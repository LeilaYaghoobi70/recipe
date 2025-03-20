package app.google.presenter.detailCateogryScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun DetailCategoryScreen(
    detailCategoryViewModel: DetailCategoryViewModel,
    categoryId: String
){
    LaunchedEffect(categoryId) {
        detailCategoryViewModel.handleEvent()
    }
}