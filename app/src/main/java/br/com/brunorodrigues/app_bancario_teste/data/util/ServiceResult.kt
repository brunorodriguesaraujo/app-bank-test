package br.com.brunorodrigues.app_bancario_teste.data.util

sealed class ServiceResult<out T> {
    data class Success<out T>(val data: T) : ServiceResult<T>()
    data class Error(val code: String? = null, val message: String) : ServiceResult<Nothing>()
}