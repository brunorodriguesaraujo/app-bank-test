package br.com.brunorodrigues.app_bancario_teste.data.remote

import br.com.brunorodrigues.app_bancario_teste.data.model.PaymentsResponse
import br.com.brunorodrigues.app_bancario_teste.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/treinamento/Login")
    suspend fun getUser() : Response<UserResponse>

    @GET("/treinamento/payments")
    suspend fun getPayments() : Response<PaymentsResponse>
}