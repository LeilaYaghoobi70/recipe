package app.google.presenter.categoryScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.google.common.ui.shimmerAnimation

@Composable
fun SpecialCategoryShimmerView(
    modifier: Modifier = Modifier.fillMaxSize().padding(12.dp),
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp), // ✅ Space between columns
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(10) { _ ->
            SpecialCategoryItem()
        }
    }
}

@Composable
private fun SpecialCategoryItem() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .size(width = 100.dp, height = 200.dp)
            .shimmerAnimation()
            .padding(10.dp)
    )
}