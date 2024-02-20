package com.example.electrolux_assignment.di

import androidx.lifecycle.ViewModel
import com.example.electrolux_assignment.presentation.viewmodel.FabricsListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFabricsListViewModel(viewModel: FabricsListViewModel): ViewModel {
        return viewModel
    }
}