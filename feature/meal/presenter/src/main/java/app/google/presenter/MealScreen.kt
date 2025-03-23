package app.google.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.google.coremodule.businessModel.MealInstruction
import app.google.presenter.arch.MealEvent
import com.example.feature.search.SearchBar
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MealScreen(
    mealViewModel: MealViewModel
) {
    val mealState by mealViewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(12.dp)
    ) {
        SearchBar(
            onSearchQueryChanged = {
                mealViewModel.handleEvent(MealEvent.Search(it))
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn(
            modifier = Modifier.weight(1F)

        ) {
            items(mealState.mealInstruction ?: emptyList()) {
                Spacer(modifier = Modifier.height(5.dp))
                MealInstructionItem(mealInstruction = it)
            }
        }
    }
}

@Composable
private fun MealInstructionItem(
    mealInstruction: MealInstruction
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(120.dp)
            .background(Color.White)
    ) {
        GlideImage(
            imageModel = { mealInstruction.thumbnail },
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(10.dp))
                .align(Alignment.CenterVertically)
        )
        Text(
            text = mealInstruction.category + "\n" + mealInstruction.name + "\n+" + mealInstruction.area,
            modifier = Modifier
                .weight(1F)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0.7f))
                .padding(horizontal = 8.dp, vertical = 8.dp),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
        )
    }
}
