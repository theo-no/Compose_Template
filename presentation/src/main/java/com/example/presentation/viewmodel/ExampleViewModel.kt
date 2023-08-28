package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.model.ExampleModel
import com.example.domain.usecase.ExampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val exampleUseCase: ExampleUseCase
): ViewModel() {
    fun getExampleModel(): ExampleModel{
        return exampleUseCase.getExampleModel()
    }
}