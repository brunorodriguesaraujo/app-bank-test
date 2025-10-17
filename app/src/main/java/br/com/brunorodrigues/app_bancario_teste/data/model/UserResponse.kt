package br.com.brunorodrigues.app_bancario_teste.data.model

import kotlinx.serialization.SerialName

data class UserResponse(
    @SerialName("customerName") val customerName: String,
    @SerialName("accountNumber") val accountNumber: String,
    @SerialName("branchName") val branchName: String,
    @SerialName("checkingAccountBalance") val checkingAccountBalance: Double,
    @SerialName("id") val id: String
)
