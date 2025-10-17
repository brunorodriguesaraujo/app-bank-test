package br.com.brunorodrigues.app_bancario_teste.domain.repository

import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User

interface UserRepository {
    suspend fun getUser() : ServiceResult<User>
}