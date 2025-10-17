package br.com.brunorodrigues.app_bancario_teste.data.mapper

import br.com.brunorodrigues.app_bancario_teste.data.model.UserResponse
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User

fun UserResponse.toDomain() = User(
    customerName = customerName,
    accountNumber = accountNumber,
    branchName = branchName,
    checkingAccountBalance = checkingAccountBalance,
    id = id
)