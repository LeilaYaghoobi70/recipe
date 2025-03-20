package app.google.presenter.detailCateogryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailCategoryViewModel @Inject constructor(
    private val getDetailCategory: GetDetailCategory
) : ViewModel() {


    fun handleEvent(detailCategoryEvent: DetailCategoryEvent){
        when(detailCategoryEvent){
            is DetailCategoryEvent.GetDetailCategory -> getDetailCategory(detailCategoryEvent.categoryId)
        }
    }

    fun getDetailCategory(categoryId: String) {
        viewModelScope.launch {

        }
    }
}