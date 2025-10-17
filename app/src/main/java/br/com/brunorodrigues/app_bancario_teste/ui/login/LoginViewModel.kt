package br.com.brunorodrigues.app_bancario_teste.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User
import br.com.brunorodrigues.app_bancario_teste.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val repository: UserRepository): ViewModel() {

    private val _state = MutableStateFlow<UserState>(UserState.Idle)
    val state = _state.asStateFlow()

    fun getUser() {
        viewModelScope.launch(context = Dispatchers.IO) {
            _state.value = UserState.Loading
            val result = repository.getUser()

            when (result) {
                is ServiceResult.Success -> _state.value = UserState.Success(result.data)
                is ServiceResult.Error -> _state.value = UserState.Error(result.message)
            }
        }
    }

    fun clearState() {
        _state.value = UserState.Idle
    }

}

sealed class UserState {
    data object Idle: UserState()
    data object Loading : UserState()
    data class Success(val data: User): UserState()
    data class Error(val message: String): UserState()
}