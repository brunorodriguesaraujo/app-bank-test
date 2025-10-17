package br.com.brunorodrigues.app_bancario_teste.ui.extension

fun String.isValidEmail() = this.contains("@")

fun String.isValidPassword() : Boolean {
    val hasSixDigitsOrMore = this.length >= 6
    val hasLetter = this.any { it.isLetter() }
    val hasDigit = this.any { it.isDigit() }

    return hasSixDigitsOrMore && hasLetter && hasDigit
}