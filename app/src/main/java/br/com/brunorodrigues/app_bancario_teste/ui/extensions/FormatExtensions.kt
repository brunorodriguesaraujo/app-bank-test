package br.com.brunorodrigues.app_bancario_teste.ui.extensions

import java.text.NumberFormat
import java.util.Locale

private const val PT = "pt"
private const val BR = "BR"

fun Double.toBrazilianCurrency(): String {
    val locale = Locale(PT, BR)
    val currencyFormatter = NumberFormat.getCurrencyInstance(locale)
    return currencyFormatter.format(this)
}