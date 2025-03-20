package app.google.presenter


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
import app.google.presenter.component.CategoryView
import app.google.presenter.component.Toolbar

@Composable
fun SearchScreen(
    viewModel: CategoryViewModel
) {
    val viewModelState by viewModel.state.collectAsState()
    RecipeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)

        ) {
            Toolbar(title = "Category")
            Spacer(Modifier.height(12.dp))
            CategoryView(viewModelState.categories)
        }
    }
}
