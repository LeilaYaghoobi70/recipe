package app.google.di

import app.google.RecipeApiService
import app.google.repository.RecipeRepository
import app.google.repository.RecipeRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRecipeRepository(
        recipeApiService: RecipeApiService
    ): RecipeRepository = RecipeRepositoryImp(
        recipeApiService = recipeApiService,
    )
}