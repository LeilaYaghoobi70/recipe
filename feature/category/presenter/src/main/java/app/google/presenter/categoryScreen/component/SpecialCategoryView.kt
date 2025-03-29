package app.google.presenter.categoryScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.google.model.SpecialCategory
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SpecialCategoryView(
    modifier: Modifier = Modifier.fillMaxSize().padding(12.dp),
    specialCategories: List<SpecialCategory>,
    navigateToDetail: (String) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp), // ✅ Space between columns
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(specialCategories.size) { index ->
            SpecialCategoryItem(
                specialCategory = specialCategories[index],
                navigateToDetail = navigateToDetail
            )
        }
    }
}

@Composable
private fun SpecialCategoryItem(
    specialCategory: SpecialCategory,
    navigateToDetail: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .size(width = 100.dp, height = 200.dp)
            .background(Color.White)
            .clickable { navigateToDetail.invoke(specialCategory.id) }
            .padding(10.dp)
    ) {
        GlideImage(
            imageModel = { specialCategory.thumbnail },
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
        )
        Text(
            text = specialCategory.name,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0.7f))
                .padding(horizontal = 8.dp, vertical = 8.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }

}