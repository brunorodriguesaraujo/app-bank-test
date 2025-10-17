package br.com.brunorodrigues.app_bancario_teste.data.repository

import br.com.brunorodrigues.app_bancario_teste.data.mapper.toDomain
import br.com.brunorodrigues.app_bancario_teste.data.remote.ApiService
import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.Payment
import br.com.brunorodrigues.app_bancario_teste.domain.repository.PaymentsRepository
import javax.inject.Inject

class PaymentsRepositoryImpl @Inject constructor(val service: ApiService) : PaymentsRepository {
    override suspend fun getPayments(): ServiceResult<List<Payment>> {
        return try {
            val response = service.getPayments()
            if (response.isSuccessful) {
                ServiceResult.Success(
                    response.body()!!.map {
                        it.toDomain()
                    }
                )
            } else ServiceResult.Error(message = response.message())
        } catch (e: Exception) {
            ServiceResult.Error(message = e.message.toString())
        }
    }
}