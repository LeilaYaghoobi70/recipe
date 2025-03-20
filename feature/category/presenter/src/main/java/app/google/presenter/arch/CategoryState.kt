package app.google.presenter.arch

import app.google.model.SpecialCategories

data class CategoryState (
    val categories: List<Pair<String, Boolean>> = emptyList(),
    val specialCategories: SpecialCategories = SpecialCategories(emptyList()),
)
