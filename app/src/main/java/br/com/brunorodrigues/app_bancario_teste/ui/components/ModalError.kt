package br.com.brunorodrigues.app_bancario_teste.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import br.com.brunorodrigues.app_bancario_teste.R
import br.com.brunorodrigues.app_bancario_teste.ui.theme.interFontFamily

@Composable
fun ErrorDialog(
    message: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(R.string.service_unavailable), style = TextStyle(
                    fontFamily = interFontFamily
                )
            )
        },
        text = {
            Text(
                text = message, style = TextStyle(
                    fontFamily = interFontFamily
                )
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.closed))
            }
        }
    )
}