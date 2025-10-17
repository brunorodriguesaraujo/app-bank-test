package br.com.brunorodrigues.app_bancario_teste.data.model

import kotlinx.serialization.SerialName

data class PaymentsResponse(
    @SerialName("paymentDate") val paymentDate: String,
    @SerialName("electricityBill") val electricityBill: String,
    @SerialName("id") val id: String
)
