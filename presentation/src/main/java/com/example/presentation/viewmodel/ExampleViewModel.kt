package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ExampleModel
import com.example.domain.usecase.ExampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "ExampleViewModel 차선호"
@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val exampleUseCase: ExampleUseCase
): ViewModel() {

    private val _exampleRepos = MutableStateFlow<List<ExampleModel>>(listOf())
    val exampleRepos: StateFlow<List<ExampleModel>> = _exampleRepos
    fun getExampleRepos(user: String) = viewModelScope.launch {
        Log.d(TAG, "getExampleRepos -> ${exampleUseCase.invoke(user)}")
        _exampleRepos.emit(exampleUseCase.invoke(user))
        Log.d(TAG, "getExampleRepos: ${exampleRepos.value}")
    }
}