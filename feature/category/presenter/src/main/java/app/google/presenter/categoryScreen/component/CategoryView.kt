package app.google.presenter.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.google.common.ui.theme.borderColor


@Composable
fun CategoryView(
    categories: List<Pair<String, Boolean>>,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
) {
    LazyRow(
        modifier = modifier,
    ) {
        items(categories.size) { item ->
            CategoryItem(categories[item])
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
private fun CategoryItem(
    value: Pair<String, Boolean>
) {
    Text(
        modifier = Modifier
            .clip(shape = CircleShape)
            .background(Color.White)
            .border(width = 1.dp, color = if (value.second) borderColor else Color.Transparent)
            .padding(horizontal = 12.dp, vertical = 2.dp),
        text = value.first,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Italic
    )
}