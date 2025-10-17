package br.com.brunorodrigues.app_bancario_teste.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import br.com.brunorodrigues.app_bancario_teste.R
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User
import br.com.brunorodrigues.app_bancario_teste.ui.components.ButtonPrimary
import br.com.brunorodrigues.app_bancario_teste.ui.components.ErrorDialog
import br.com.brunorodrigues.app_bancario_teste.ui.components.TextFieldModule
import br.com.brunorodrigues.app_bancario_teste.ui.extensions.isValidEmail
import br.com.brunorodrigues.app_bancario_teste.ui.extensions.isValidPassword
import br.com.brunorodrigues.app_bancario_teste.ui.theme.interFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToPaymentsDetails: (user: User) -> Unit
) {

    var isLoading = false
    val state by viewModel.state.collectAsState()
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isErrorEmail by rememberSaveable { mutableStateOf(false) }
    var isErrorPassword by rememberSaveable { mutableStateOf(false) }
    val isButtonEnabled =
        !isErrorPassword && !isErrorEmail && email.isNotEmpty() && password.isNotEmpty()

    when (state) {
        is UserState.Loading -> isLoading = true
        is UserState.Success -> {
            onNavigateToPaymentsDetails((state as UserState.Success).data)
            viewModel.clearState()
            email = ""
            password = ""
        }
        is UserState.Error -> {
            ErrorDialog(
                message = stringResource(R.string.try_later),
                onDismiss = { viewModel.clearState() }
            )
        }

        else -> {}
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.image_logo),
                contentDescription = stringResource(R.string.image_logo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
            )
            TextFieldModule(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(8.dp)),
                value = email,
                placeholder = stringResource(R.string.email),
                textStyle = MaterialTheme.typography.titleMedium,
                isError = isErrorEmail,
                errorMessage = stringResource(R.string.email_invalid),
                onValueChange = {
                    email = it
                    isErrorEmail = !email.isValidEmail()
                }
            )

            TextFieldModule(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(8.dp)),
                placeholder = stringResource(R.string.password),
                value = password,
                textStyle = MaterialTheme.typography.titleMedium,
                isError = isErrorPassword,
                errorMessage = stringResource(R.string.password_error_description),
                onValueChange = {
                    password = it
                    isErrorPassword = !password.isValidPassword()
                }
            )

            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .size(50.dp),
                text = stringResource(R.string.login),
                isLoading = isLoading,
                textStyle = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                ),
                enabled = isButtonEnabled
            ) {
                viewModel.getUser()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
//    LoginScreen()
}