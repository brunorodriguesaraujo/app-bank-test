package br.com.brunorodrigues.app_bancario_teste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.com.brunorodrigues.app_bancario_teste.ui.login.LoginScreen
import br.com.brunorodrigues.app_bancario_teste.ui.navigation.Login
import br.com.brunorodrigues.app_bancario_teste.ui.navigation.PaymentsDetails
import br.com.brunorodrigues.app_bancario_teste.ui.navigation.UserNav
import br.com.brunorodrigues.app_bancario_teste.ui.payments.PaymentDetailsScreen
import br.com.brunorodrigues.app_bancario_teste.ui.theme.AppbancariotesteTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.json.Json

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppbancariotesteTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Login) {
                    composable<Login> {
                        LoginScreen(onNavigateToPaymentsDetails = { user ->
                            navController.navigate(
                                route = PaymentsDetails(
                                    data = Json.encodeToString(UserNav.fromDomain(user))
                                )
                            )
                        })
                    }
                    composable<PaymentsDetails> { backStackEntry ->
                        val screen: PaymentsDetails = backStackEntry.toRoute()
                        val user = screen.let { Json.decodeFromString<UserNav>(it.data) }.toDomain()
                        PaymentDetailsScreen(user = user, onNavigateBack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}