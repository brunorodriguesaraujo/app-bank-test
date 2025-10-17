package br.com.brunorodrigues.app_bancario_teste.data.repository

import br.com.brunorodrigues.app_bancario_teste.data.mapper.toDomain
import br.com.brunorodrigues.app_bancario_teste.data.model.PaymentsResponse
import br.com.brunorodrigues.app_bancario_teste.data.remote.ApiService
import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.repository.PaymentsRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test

@ExperimentalCoroutinesApi
class PaymentsRepositoryTest {

    private val apiService = mockk<ApiService>()
    private lateinit var repository: PaymentsRepository

    @Before
    fun setup() {
        repository = PaymentsRepositoryImpl(apiService)
    }

    @Test
    fun `should emit Success when api returns data`() = runTest {
        val mockPayments = listOf(PaymentsResponse(
            id = "Teste",
            electricityBill = "100",
            paymentDate = "10/02/2025"
        ))

        val expectedPayments = mockPayments.map { it.toDomain() }

        coEvery { apiService.getPayments() } returns retrofit2.Response.success(mockPayments)

        val result = repository.getPayments()

        assertTrue(result is ServiceResult.Success)
        assertEquals(expectedPayments, (result as ServiceResult.Success).data)
    }

    @Test
    fun `should emit Error when api returns error`() = runTest {
        coEvery { apiService.getPayments() } throws RuntimeException("fail")

        val result = repository.getPayments()

        assertTrue(result is ServiceResult.Error)
        assertEquals("fail", (result as ServiceResult.Error).message)
    }
}