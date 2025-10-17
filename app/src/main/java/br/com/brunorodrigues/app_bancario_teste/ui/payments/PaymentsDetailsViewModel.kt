package br.com.brunorodrigues.app_bancario_teste.ui.payments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.Payments
import br.com.brunorodrigues.app_bancario_teste.domain.repository.PaymentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PaymentsDetailsViewModel @Inject constructor(val repository: PaymentsRepository): ViewModel() {

    private val _state = MutableStateFlow<PaymentsState>(PaymentsState.Idle)
    val state = _state.asStateFlow()

    fun getPayments() {
        viewModelScope.launch(context = Dispatchers.IO) {
            _state.value = PaymentsState.Loading
            val result = repository.getPayments()

            when (result) {
                is ServiceResult.Success -> _state.value = PaymentsState.Success(result.data)
                is ServiceResult.Error -> _state.value = PaymentsState.Error(result.message)
            }
        }
    }


}

sealed class PaymentsState {
    data object Idle: PaymentsState()
    data object Loading : PaymentsState()
    data class Success(val data: Payments): PaymentsState()
    data class Error(val message: String): PaymentsState()
}