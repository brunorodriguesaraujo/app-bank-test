package br.com.brunorodrigues.app_bancario_teste.di

import br.com.brunorodrigues.app_bancario_teste.data.remote.ApiService
import br.com.brunorodrigues.app_bancario_teste.data.repository.UserRepositoryImpl
import br.com.brunorodrigues.app_bancario_teste.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    fun provideUserRepository(apiService: ApiService): UserRepository =
        UserRepositoryImpl(service = apiService)

}