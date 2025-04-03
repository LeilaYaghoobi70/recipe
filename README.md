# 🍽️ Recipe App

A **modern Android app** built using the latest **Kotlin & Jetpack technologies**. The app follows **MVI + Clean Architecture** and is designed with **modularization** for scalability and maintainability.

## ✨ Features
- 📌 **Category-based meal browsing**
- 🔍 **Search meals by first letter**
- 📖 **View meal details & instructions**
- 🖼️ **Image loading with Glide**
- ⚡ **Fast API calls with Ktor**
- 🚀 **DI with Hilt**
- 🧪 **BDD testing with Kotest**

---

## 🏛 **Architecture**
The app follows **Clean Architecture** with modularization:
- 📂 app/
- 📂 common/         # Shared utilities, networking
- 📂 feature/
    - 📂 category/    # Category feature module  
        - 📂 data/    # Repository, API services, DTOs  
        - 📂 domain/  # Use Cases, Business Logic  
        - 📂 presenter/ # ViewModel, UI  
    - 📂 meal/        # Meal feature module  
        - 📂 data/    # Repository, API services, DTOs  
        - 📂 domain/  # Use Cases, Business Logic  
        - 📂 presenter/ # ViewModel, UI  



---

### 🔥 Why this Architecture?
- **Separation of Concerns**: Each layer has a single responsibility.
- **Scalability**: Modules can be extended independently.
- **Testability**: Business logic (domain layer) remains independent.
  
----

## 🛠 **Tech Stack**
### 🔹 **UI**
- 🎨 [Jetpack Compose](https://developer.android.com/jetpack/compose)
- 🧭 [Compose Navigation](https://developer.android.com/jetpack/compose/navigation)
- 🖼️ [Glide](https://github.com/bumptech/glide)

### 🔹 **Networking**
- 🌐 [Ktor Client](https://ktor.io/docs/client.html)

### 🔹 **Dependency Injection**
- 🔥 [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

### 🔹 **Testing**
- 🧪 [Kotest](https://kotest.io/) (BDD testing)
- ✅ [Mockk](https://mockk.io/) (Mocking framework)

---

## 🧪 **Testing with Kotest**
We use **Kotest** to write **BDD-style tests** for `CategoryViewModel`.

```kotlin

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
        }.....

