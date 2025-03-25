package com.example.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(
    onSearchQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val query = remember { mutableStateOf("") }
    OutlinedTextField(
        value = query.value,
        onValueChange = {
            query.value = it
            onSearchQueryChanged.invoke(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .height(48.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearchQueryChanged.invoke(query.value)
            }
        ),
        singleLine = true,
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            focusedIndicatorColor = Color.White,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Blue,
            unfocusedLabelColor = Color.Gray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    val searchQuery = remember { mutableStateOf("") }
    SearchBar(
        onSearchQueryChanged = { searchQuery.value = it },
    )
}
