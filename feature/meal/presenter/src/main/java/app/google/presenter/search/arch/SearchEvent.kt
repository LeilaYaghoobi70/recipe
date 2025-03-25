package app.google.presenter.search.arch

sealed class SearchEvent {
    data class Search(val letter: String): SearchEvent()
}
