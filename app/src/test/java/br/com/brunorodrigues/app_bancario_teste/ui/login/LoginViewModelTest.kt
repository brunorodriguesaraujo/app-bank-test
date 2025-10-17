package br.com.brunorodrigues.app_bancario_teste.ui.login

import br.com.brunorodrigues.app_bancario_teste.data.util.DataStoreUtil
import br.com.brunorodrigues.app_bancario_teste.data.util.ServiceResult
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User
import br.com.brunorodrigues.app_bancario_teste.domain.repository.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
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
    private val dataStore = mockk<DataStoreUtil>(relaxed = true)
    private lateinit var viewModel: LoginViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        coEvery { dataStore.readString("email") } returns "bruno@123"
        coEvery { dataStore.readString("password") } returns "1234tro"
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getUser should emit Success state when repository returns data`() = runTest {
        // Arrange
        val mockData = User(
            customerName = "Teste",
            accountNumber = "100",
            branchNumber = "0001",
            checkingAccountBalance = 12.0,
            id = "1"
        )
        coEvery { repository.getUser() } returns ServiceResult.Success(mockData)

        // Act
        viewModel = LoginViewModel(repository, dataStore)
        viewModel.getUser()

        // Assert
        val state = viewModel.state.value
        assertTrue(state is UserState.Success)
        assertEquals(mockData, state.data)
    }

    @Test
    fun `getUser should emit Error state when repository returns error`() = runTest {
        // Arrange
        coEvery { repository.getUser() } returns ServiceResult.Error(message = "Error")

        // Act
        viewModel = LoginViewModel(repository, dataStore)
        viewModel.getUser()

        // Assert
        val state = viewModel.state.value
        assertEquals("Error", (state as UserState.Error).message)
    }

    @Test
    fun `saveLogin should call DataStoreUtil with correct values`() = runTest {
        // Arrange
        viewModel = LoginViewModel(repository, dataStore)

        // Act
        viewModel.saveLogin("bruno@123", "1234tro")

        // Assert
        coVerify { dataStore.saveString("email", "bruno@123") }
        coVerify { dataStore.saveString("password", "1234tro") }
    }

    @Test
    fun `getDataLogin should update state with stored values`() = runTest {
        // Arrange
        coEvery { dataStore.readString("email") } returns "test@mail.com"
        coEvery { dataStore.readString("password") } returns "123456"

        viewModel = LoginViewModel(repository, dataStore)

        // Act
        viewModel.getDataLogin()

        // Assert
        val (email, password) = viewModel.dataLoginState.value
        assertEquals("test@mail.com", email)
        assertEquals("123456", password)
    }
}
