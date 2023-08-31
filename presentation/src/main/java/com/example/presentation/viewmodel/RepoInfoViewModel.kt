package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.RepoDto
import com.example.domain.model.RepoInfoDto
import com.example.domain.usecase.GetRepoInfoUseCase
import com.example.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoInfoViewModel @Inject constructor(
    private val getRepoInfoUseCase: GetRepoInfoUseCase
): ViewModel() {

    private val _selectedRepo = MutableStateFlow<RepoInfoDto>(RepoInfoDto())
    val selectedRepo: StateFlow<RepoInfoDto> = _selectedRepo

    fun getRepoInfo(user: String, repo: String) = viewModelScope.launch {
        _selectedRepo.emit(getRepoInfoUseCase.invoke(user, repo))
    }

}