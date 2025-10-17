package br.com.brunorodrigues.app_bancario_teste.di

import br.com.brunorodrigues.app_bancario_teste.data.remote.ApiService
import br.com.brunorodrigues.app_bancario_teste.data.repository.PaymentsRepositoryImpl
import br.com.brunorodrigues.app_bancario_teste.domain.repository.PaymentsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PaymentsModule {

    @Provides
    fun providePaymentsRepository(apiService: ApiService): PaymentsRepository =
        PaymentsRepositoryImpl(service = apiService)

}