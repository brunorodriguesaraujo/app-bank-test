package br.com.brunorodrigues.app_bancario_teste.ui.payments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.brunorodrigues.app_bancario_teste.R
import br.com.brunorodrigues.app_bancario_teste.ui.components.AppBarModule
import br.com.brunorodrigues.app_bancario_teste.ui.theme.AppbancariotesteTheme
import br.com.brunorodrigues.app_bancario_teste.ui.theme.interFontFamily
import br.com.brunorodrigues.app_bancario_teste.ui.theme.steelBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentDetailsScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(paddingValues = innerPadding)) {
            AppBarModule(
                title = stringResource(R.string.payments),
                textStyle = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            ) {

            }

            Text(
                text = "Detalhes do pagamento",
                style = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                ),
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "Cliente: Maria Silva",
                style = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )

            Text(
                text = "Agência: 1234 | Conta: 56789-0",
                style = TextStyle(
                    fontFamily = interFontFamily,
                    fontSize = 14.sp,
                    color = steelBlue
                ),
                modifier = Modifier.padding(top = 4.dp, start = 16.dp)
            )

            Text(
                text = "Saldo: R$ 1.500,00",
                style = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                ),
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
                items(3) {
                    ListItemsBillsPaid()
                }
            }

        }
    }

}

@Composable
fun ListItemsBillsPaid() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Conta de luz",
                    style = TextStyle(
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    ),
                )
                Text(
                    text = "R$ 120,00",
                    style = TextStyle(
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = steelBlue
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Text(
                text = "15/07/2025",
                style = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = steelBlue,
                ),
            )
        }
    }
}

@Preview
@Composable
private fun PaymentDetailsScreenPreview() {
    AppbancariotesteTheme {
        PaymentDetailsScreen()
    }
}