package br.com.brunorodrigues.app_bancario_teste.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brunorodrigues.app_bancario_teste.data.util.DataStoreUtil
import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User
import br.com.brunorodrigues.app_bancario_teste.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val repository: UserRepository,
    val dataStore: DataStoreUtil
) : ViewModel() {

    private val _state = MutableStateFlow<UserState>(UserState.Idle)
    val state = _state.asStateFlow()

    private val _dataLoginState = MutableStateFlow<Pair<String?, String?>>(null to null)
    val dataLoginState = _dataLoginState.asStateFlow()

    init {
        getDataLogin()
    }

    fun getUser() {
        viewModelScope.launch {
            _state.value = UserState.Loading
            val result = repository.getUser()

            when (result) {
                is ServiceResult.Success -> _state.value = UserState.Success(result.data)
                is ServiceResult.Error -> _state.value = UserState.Error(result.message)
            }
        }
    }

    fun saveLogin(email: String, password: String) {
        viewModelScope.launch {
            dataStore.saveString("email", email)
            dataStore.saveString("password", password)
        }
    }

    fun getDataLogin() {
        viewModelScope.launch {
            val email = dataStore.readString("email")
            val password = dataStore.readString("password")
            _dataLoginState.value = email to password
        }
    }

    fun clearState() {
        _dataLoginState.value = null to null
        _state.value = UserState.Idle
    }

}

sealed class UserState {
    data object Idle : UserState()
    data object Loading : UserState()
    data class Success(val data: User) : UserState()
    data class Error(val message: String) : UserState()
}