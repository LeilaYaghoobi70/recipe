package app.google.di

import app.google.repository.RecipeRepository
import app.google.repository.RecipeRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideRecipeRepository(
        recipeRepository: RecipeRepositoryImp
    ): RecipeRepository
}