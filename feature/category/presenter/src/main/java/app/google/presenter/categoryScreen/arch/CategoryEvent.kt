package app.google.presenter.categoryScreen.arch

sealed class CategoryEvent {
    data class GetSpecialCategory(
       val  name: String
    ) : CategoryEvent()
}