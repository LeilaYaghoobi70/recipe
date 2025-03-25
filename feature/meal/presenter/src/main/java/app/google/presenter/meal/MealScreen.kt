package app.google.presenter.meal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.google.presenter.meal.arch.MealEvent
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MealScreen(
    mealViewModel: MealViewModel,
    categoryId: String
){
    val state by mealViewModel.state.collectAsState()
    LaunchedEffect(categoryId) {
        mealViewModel.handleEvent(MealEvent.GetMeal(categoryId))
    }
    Box (
        contentAlignment = Alignment.Center
    ){
        GlideImage(
            imageModel = { state.mealInstruction?.thumbnail },
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
        )
        Text(
            text =  state.mealInstruction?.instructions ?: "",
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .wrapContentWidth(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0.7f))
                .padding(horizontal = 8.dp, vertical = 8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
    }

}