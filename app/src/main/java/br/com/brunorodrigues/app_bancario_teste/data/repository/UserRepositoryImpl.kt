package br.com.brunorodrigues.app_bancario_teste.data.repository

import br.com.brunorodrigues.app_bancario_teste.data.mapper.toDomain
import br.com.brunorodrigues.app_bancario_teste.data.remote.ApiService
import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User
import br.com.brunorodrigues.app_bancario_teste.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val service: ApiService) : UserRepository {
    override suspend fun getUser(): ServiceResult<User> {
        return try {
            val response = service.getUser()
            if (response.isSuccessful) {
                ServiceResult.Success(
                    response.body()!!.toDomain()
                )
            } else ServiceResult.Error(message = response.message())
        } catch (e: Exception) {
            ServiceResult.Error(message = e.message.toString())
        }
    }
}