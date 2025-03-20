package app.google.presenter.mainCategoryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import app.google.presenter.mainCategoryScreen.component.Toolbar

@Composable
fun MainScreen(
    navigateToMail: () -> Unit,
) {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Toolbar(
            title = "Category",
            navigateToMail = navigateToMail
        )
        AppNavGraph(navController = navController)
    }
}
