package br.com.brunorodrigues.app_bancario_teste.data.mapper

import br.com.brunorodrigues.app_bancario_teste.data.model.PaymentsResponse
import br.com.brunorodrigues.app_bancario_teste.domain.entity.Payment

fun PaymentsResponse.toDomain() = Payment(
    paymentDate = paymentDate,
    electricityBill = electricityBill,
    id = id
)