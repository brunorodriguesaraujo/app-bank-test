package br.com.brunorodrigues.app_bancario_teste.domain.repository

import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.Payment

interface PaymentsRepository {
    suspend fun getPayments() : ServiceResult<List<Payment>>
}