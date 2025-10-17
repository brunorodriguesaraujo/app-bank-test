package br.com.brunorodrigues.app_bancario_teste.ui.login

import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User
import br.com.brunorodrigues.app_bancario_teste.domain.repository.UserRepository
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
class LoginViewModelTest {

    private val repository = mockk<UserRepository>()
    private lateinit var viewModel: LoginViewModel

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
    fun `init should emit Success state when repository returns data`() = runTest {
        val mockData = User(
            customerName = "Teste",
            accountNumber = "100",
            branchNumber = "0001",
            checkingAccountBalance = 12.0,
            id = "1"
        )

        coEvery { repository.getUser() } returns ServiceResult.Success(mockData)

        viewModel = LoginViewModel(repository)
        viewModel.getUser()

        val state = viewModel.state.value

        assertTrue(state is UserState.Success)
        assertEquals(mockData, state.data)
    }

    @Test
    fun `init should emit Error state when repository returns error`() = runTest {
        coEvery { repository.getUser() } returns ServiceResult.Error(message = "Error")

        viewModel = LoginViewModel(repository)
        viewModel.getUser()

        val state = viewModel.state.value

        assertEquals("Error", (state as UserState.Error).message)
    }

}