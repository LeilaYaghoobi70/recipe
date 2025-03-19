package app.google.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.usecase.GetCategories
import app.google.usecase.GetSpecialCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSpecialCategory: GetSpecialCategory,
    private val getCategories: GetCategories,
): ViewModel()  {

    init {
        viewModelScope.launch {
           getCategories.invoke()
        }
    }

    private fun getSpecialCategory(categoryName: String){
        viewModelScope.launch {
            getSpecialCategory.invoke(categoryName = categoryName)
        }
    }
}