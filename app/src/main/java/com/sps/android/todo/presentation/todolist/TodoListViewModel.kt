package com.sps.android.presentation.todo

import androidx.lifecycle.ViewModel
import com.sps.android.domain.usecase.GetTodoItemsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(private val getTodoItemsListUseCase: GetTodoItemsListUseCase) :
    ViewModel() {
    private val _searchToken = MutableStateFlow("")
    val searchToken: StateFlow<String> = _searchToken
    val todoList = searchToken
        .flatMapLatest { query ->
            getTodoItemsListUseCase.getTodoList(query)
        }

    fun updateSearchToken(newText: String) {
        _searchToken.value = newText
    }
}