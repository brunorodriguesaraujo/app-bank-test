package br.com.brunorodrigues.app_bancario_teste.ui.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun ButtonPrimary(
    modifier: Modifier,
    text: String,
    textStyle: TextStyle,
    onClick: () -> Unit
    ) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Text(text = text, style = textStyle)
    }
}