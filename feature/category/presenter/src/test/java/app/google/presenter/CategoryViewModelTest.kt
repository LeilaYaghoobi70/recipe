package app.google.presenter

import app.google.model.Categories
import app.google.model.SpecialCategory
import app.google.presenter.categoryScreen.CategoryViewModel
import app.google.presenter.categoryScreen.arch.CategoryEvent
import app.google.usecase.GetCategories
import app.google.usecase.GetSpecialCategory
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*

@OptIn(ExperimentalCoroutinesApi::class)
class CategoryViewModelTest : BehaviorSpec({

    val getSpecialCategory: GetSpecialCategory = mockk()
    val getCategories: GetCategories = mockk()
    val testDispatcher = StandardTestDispatcher()

    lateinit var categoryViewModel: CategoryViewModel

    beforeTest {
        Dispatchers.setMain(testDispatcher)
    }

    afterTest {
        Dispatchers.resetMain()
    }

    Given("CategoryViewModel is initialized") {
        val mockCategories = Categories(listOf("Category1", "Category2", "Category3"))
        val specialCategories = listOf(SpecialCategory(id = "1234", name = "fish", thumbnail = ""))

        When("Fetching categories and special category succeeds") {
            coEvery { getCategories.invoke() } returns mockCategories
            coEvery { getSpecialCategory.invoke("Category1") } returns specialCategories

            runTest {
                categoryViewModel = CategoryViewModel(getSpecialCategory, getCategories)
                advanceUntilIdle()

                Then("Categories should be fetched") {
                    coVerify(exactly = 1) { getCategories.invoke() }
                }

                Then("First special category should be fetched") {
                    coVerify(exactly = 1) { getSpecialCategory.invoke("Category1") }
                }

                Then("State should be updated with categories") {
                    categoryViewModel.state.value.categories shouldBe listOf(
                        "Category1" to true,
                        "Category2" to false,
                        "Category3" to false
                    )
                }

                And("State should update special categories") {
                    categoryViewModel.state.value.specialCategories shouldBe specialCategories
                }
            }
        }

        When("Fetching categories fails") {
            coEvery { getCategories.invoke() } throws Exception("Failed to fetch categories")

            runTest {
                categoryViewModel = CategoryViewModel(getSpecialCategory, getCategories)
                advanceUntilIdle()

                Then("Error state should be true") {
                    categoryViewModel.state.value.showError shouldBe true
                }
            }
        }

        When("Fetching special category fails") {
            coEvery { getCategories.invoke() } returns mockCategories
            coEvery { getSpecialCategory.invoke("Category1") } throws Exception("Failed to fetch special category")

            runTest {
                categoryViewModel = CategoryViewModel(getSpecialCategory, getCategories)
                advanceUntilIdle()

                Then("Error state should be true") {
                    categoryViewModel.state.value.showError shouldBe true
                }
            }
        }
    }

    Given("User clicks on a category") {
        val specialCategories = listOf(SpecialCategory(id = "1234", name = "fish", thumbnail = ""))

        When("Fetching special category succeeds") {
            coEvery { getSpecialCategory.invoke("Category1") } returns specialCategories

            runTest {
                categoryViewModel = CategoryViewModel(getSpecialCategory, getCategories)
                categoryViewModel.handleEvent(CategoryEvent.GetSpecialCategory("Category1"))
                advanceUntilIdle()

                Then("Selected category should be updated") {
                    categoryViewModel.state.value.specialCategories shouldBe specialCategories
                }

                And("Loading state should be false") {
                    categoryViewModel.state.value.showSpecialCategoryLoading shouldBe false
                }
            }
        }

        When("Fetching special category fails") {
            coEvery { getSpecialCategory.invoke("Category1") } throws Exception("Failed to fetch special category")

            runTest {
                categoryViewModel = CategoryViewModel(getSpecialCategory, getCategories)
                categoryViewModel.handleEvent(CategoryEvent.GetSpecialCategory("Category1"))
                advanceUntilIdle()

                Then("Error state should be true") {
                    categoryViewModel.state.value.showError shouldBe true
                }
            }
        }
    }
})
