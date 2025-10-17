package br.com.brunorodrigues.app_bancario_teste.ui.payments

import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.Payment
import br.com.brunorodrigues.app_bancario_teste.domain.repository.PaymentsRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class PaymentsDetailsViewModelTest {

    private val repository = mockk<PaymentsRepository>()
    private lateinit var viewModel: PaymentsDetailsViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should emit Success state when repository returns data`() = runTest {
        val mockData = listOf(
            Payment(
                id = "Teste",
                electricityBill = "100",
                paymentDate = "10/02/2025"
            )
        )

        coEvery { repository.getPayments() } returns ServiceResult.Success(mockData)

        viewModel = PaymentsDetailsViewModel(repository)

        val state = viewModel.state.value

        assertTrue(state is PaymentsState.Success)
        assertEquals(mockData, state.data)
    }

    @Test
    fun `should emit Error state when repository returns error`() = runTest {
        coEvery { repository.getPayments() } returns ServiceResult.Error(message = "Error")

        viewModel = PaymentsDetailsViewModel(repository)

        val state = viewModel.state.value

        assertEquals("Error", (state as PaymentsState.Error).message)
    }

}