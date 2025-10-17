package br.com.brunorodrigues.app_bancario_teste.data.repository

import br.com.brunorodrigues.app_bancario_teste.data.mapper.toDomain
import br.com.brunorodrigues.app_bancario_teste.data.model.UserResponse
import br.com.brunorodrigues.app_bancario_teste.data.remote.ApiService
import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.repository.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class UserRepositoryTest {

    private val apiService = mockk<ApiService>()
    private lateinit var repository: UserRepository

    @Before
    fun setup() {
        repository = UserRepositoryImpl(apiService)
    }

    @Test
    fun `should emit Success when api returns data`() = runTest {
        // Arrange
        val mockUsers = listOf(UserResponse(
            customerName = "Teste",
            accountNumber = "100",
            branchNumber = "0001",
            checkingAccountBalance = 12.0,
            id = "1"
        ))
        coEvery { apiService.getUser() } returns retrofit2.Response.success(mockUsers)

        // Act
        val result = repository.getUser()

        // Assert
        assertTrue(result is ServiceResult.Success)
        assertEquals(mockUsers.first().toDomain(), (result as ServiceResult.Success).data)
    }

    @Test
    fun `should emit Error when api returns error`() = runTest {
        // Arrange
        coEvery { apiService.getUser() } throws RuntimeException("fail")

        // Act
        val result = repository.getUser()

        // Assert
        assertTrue(result is ServiceResult.Error)
        assertEquals("fail", (result as ServiceResult.Error).message)
    }
}