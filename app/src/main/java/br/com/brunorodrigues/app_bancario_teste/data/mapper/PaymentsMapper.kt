package br.com.brunorodrigues.app_bancario_teste.data.mapper

import br.com.brunorodrigues.app_bancario_teste.data.model.PaymentsResponse
import br.com.brunorodrigues.app_bancario_teste.domain.entity.Payments

fun PaymentsResponse.toDomain() = Payments(
    paymentDate = paymentDate,
    electricityBill = electricityBill,
    id = id
)