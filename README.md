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

### 🔹 **Configuration Management**
- 📦 **[TOML for Gradle Dependency Catalogs](https://developer.android.com/build/migrate-to-catalogs)**:
    - Using TOML-based catalogs to manage dependencies, versions, and other configurations in Gradle.
    - This allows centralized dependency version management and improves build reproducibility across different environments.
---
## 📸 **Screenshots**
Here are some screenshots of the app in action:

<div style="display: flex; justify-content: space-between;">
<img width="300" alt="Screenshot 1404-01-14 at 18 19 29" src="https://github.com/user-attachments/assets/6d1f8d44-a163-4c19-b092-c073e55260ae" />
<img width="300" alt="Screenshot 1404-01-14 at 18 20 04" src="https://github.com/user-attachments/assets/c0babc5f-2cb3-4362-aab4-192c52b857f4" />
 <img width="300" alt="Screenshot 1404-01-14 at 18 26 33" src="https://github.com/user-attachments/assets/1acefbc8-db49-4b54-b9ae-47aa06979382" />
</div>

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

