package br.com.brunorodrigues.app_bancario_teste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.brunorodrigues.app_bancario_teste.ui.login.LoginScreen
import br.com.brunorodrigues.app_bancario_teste.ui.theme.AppbancariotesteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppbancariotesteTheme {
                LoginScreen()
            }
        }
    }
}