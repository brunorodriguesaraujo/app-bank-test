package br.com.brunorodrigues.app_bancario_teste.domain.entity

data class User(
    val customerName: String,
    val accountNumber: String,
    val branchNumber: String,
    val checkingAccountBalance: Double,
    val id: String
)
