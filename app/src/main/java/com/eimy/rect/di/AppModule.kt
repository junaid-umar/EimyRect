package com.eimy.rect.di

import com.eimy.rect.domain.rectangle.MaxHistFinder
import com.eimy.rect.domain.rectangle.RectangleFinder
import com.eimy.rect.domain.usecase.SearchLargestRectangle
import com.eimy.rect.presentation.model.RectangleUIMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {



    @Provides
    fun provideMaxHistFinder(): MaxHistFinder =
        MaxHistFinder

    @Provides
    fun provideRectangleFinder(): RectangleFinder =
        RectangleFinder


    @Provides
    fun provideRectangleUiMapper(): RectangleUIMapper =
        RectangleUIMapper()

    @Provides
    fun provideSearchLargestRectangle(rectangleFinder: RectangleFinder): SearchLargestRectangle =
        SearchLargestRectangle(rectangleFinder)

}
