package com.example.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.RepoDto
import com.example.domain.usecase.SearchReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "SearchReposViewModel 차선호"
@HiltViewModel
class SearchReposViewModel @Inject constructor(
    private val searchReposUseCase: SearchReposUseCase
): ViewModel() {

    private val _userName = mutableStateOf("")
    val userName: State<String> = _userName
    fun setUserName(name: String){
        _userName.value = name
    }

    private val _exampleRepos = MutableStateFlow<List<RepoDto>>(listOf())
    val exampleRepos: StateFlow<List<RepoDto>> = _exampleRepos
    fun getUserRepos(user: String) = viewModelScope.launch {
        Log.d(TAG, "getUserRepos -> ${searchReposUseCase.invoke(user)}")
        _exampleRepos.emit(searchReposUseCase.invoke(user))
        Log.d(TAG, "getUserRepos: ${exampleRepos.value}")
    }
}