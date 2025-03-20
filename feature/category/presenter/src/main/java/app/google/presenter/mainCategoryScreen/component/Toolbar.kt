package app.google.presenter.categoryScreen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.google.presenter.mainCategoryScreen.Routes


@Composable
fun Toolbar(
    modifier: Modifier = Modifier.fillMaxWidth().height(58.dp),
    title: String,
    navigateToMail: () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1F),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Left,
            )
            Icon(
                modifier = Modifier.clickable {
                    navigateToMail()
                },
                imageVector = Icons.Outlined.Search,
                contentDescription = null
            )
        }
        HorizontalDivider()
    }

}

@Composable
@Preview
fun PreviewToolbar() {
    Toolbar(
        title = "Just For test",
        navigateToMail = {},
    )
}