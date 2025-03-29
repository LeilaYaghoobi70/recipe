package app.google.presenter.categoryScreen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.google.common.ui.shimmerAnimation

@Composable
fun CategoryShimmerView(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp),
) {
    LazyRow(
        modifier = modifier,
    ) {
        items(5) { _ ->
            Spacer(
                modifier = Modifier
                    .size(width = 100.dp, height = 30.dp)
                    .clip(CircleShape)
                    .shimmerAnimation()
                    .padding(horizontal = 15.dp, vertical = 2.dp),
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}