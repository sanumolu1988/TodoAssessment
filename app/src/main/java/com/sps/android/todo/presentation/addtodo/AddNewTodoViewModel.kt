package com.sps.android.presentation.addtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.android.domain.model.TodoModel
import com.sps.android.domain.usecase.AddNewTodoItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNewTodoViewModel @Inject constructor(private val addNewTodoItemUseCase: AddNewTodoItemUseCase) :
    ViewModel() {

    fun addNewTodo(newTodoLabel: String) {
        viewModelScope.launch {
            addNewTodoItemUseCase.addNewTodoItem(TodoModel(label = newTodoLabel))
        }
    }
}