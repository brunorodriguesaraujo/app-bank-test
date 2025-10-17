package br.com.brunorodrigues.app_bancario_teste.ui.payments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import br.com.brunorodrigues.app_bancario_teste.R
import br.com.brunorodrigues.app_bancario_teste.domain.entity.Payment
import br.com.brunorodrigues.app_bancario_teste.domain.entity.User
import br.com.brunorodrigues.app_bancario_teste.ui.components.AppBarModule
import br.com.brunorodrigues.app_bancario_teste.ui.components.ErrorDialog
import br.com.brunorodrigues.app_bancario_teste.ui.extensions.toBrazilianCurrency
import br.com.brunorodrigues.app_bancario_teste.ui.theme.AppbancariotesteTheme
import br.com.brunorodrigues.app_bancario_teste.ui.theme.interFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentDetailsScreen(
    viewModel: PaymentsDetailsViewModel = hiltViewModel(),
    user: User?,
    onNavigateBack: () -> Unit
) {

    val state by viewModel.state.collectAsState()
    val payments = (state as? PaymentsState.Success)?.data.orEmpty()
    val isLoading: Boolean = state is PaymentsState.Loading

    if (state is PaymentsState.Error) {
        ErrorDialog(
            message = stringResource(R.string.try_later),
            onDismiss = onNavigateBack
        )
    }

    if (isLoading) Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
    else Column {
        AppBarModule(
            title = stringResource(R.string.payments),
            textStyle = MaterialTheme.typography.titleLarge,
            onClickBackButton = onNavigateBack
        )

        Text(
            text = stringResource(R.string.payments_details),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = stringResource(R.string.name, user?.customerName ?: ""),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )

        Text(
            text = stringResource(
                R.string.branch_account_number,
                user?.branchNumber ?: "",
                user?.accountNumber ?: ""
            ),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp, start = 16.dp)
        )

        Text(
            text = stringResource(
                R.string.balance,
                user?.checkingAccountBalance?.toBrazilianCurrency() ?: ""
            ),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(top = 24.dp, start = 16.dp)
        )

        Text(
            text = stringResource(R.string.bills_paid),
            style = TextStyle(
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(top = 30.dp, start = 16.dp)
        )
        LazyColumn {
            items(payments) {
                ListItemsBillsPaid(it)
            }
        }

    }

}

@Composable
fun ListItemsBillsPaid(payment: Payment) {
    Column(modifier = Modifier.padding(top = 16.dp, end = 16.dp, start = 16.dp, bottom = 24.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = stringResource(R.string.electricity_bill),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = payment.electricityBill,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Text(
                text = payment.paymentDate,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}

@Preview
@Composable
private fun PaymentDetailsScreenPreview() {
    AppbancariotesteTheme {
        PaymentDetailsScreen(user = null, onNavigateBack = {})
    }
}