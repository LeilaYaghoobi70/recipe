package app.google.data.di

import app.google.data.repository.MealRepositoryImp
import app.google.repository.MealRepository
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
    fun provideMealRepositoryImp(
        recipeRepository: MealRepositoryImp
    ): MealRepository
}