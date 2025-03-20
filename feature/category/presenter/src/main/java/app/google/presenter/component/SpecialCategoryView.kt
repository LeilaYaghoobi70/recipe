package app.google.presenter.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.google.model.SpecialCategories

@Composable
fun SpecialCategoryView(
    modifier: Modifier = Modifier.fillMaxSize(),
    specialCategories: SpecialCategories
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(specialCategories.specialCategories.size) { item ->

        }
    }
}

@Composable
private fun SpecialCategoryItem(){
  /*  GlideImage(
        imageModel = { "https://example.com/image.jpg" },
        modifier = Modifier.size(100.dp)
    )*/
}