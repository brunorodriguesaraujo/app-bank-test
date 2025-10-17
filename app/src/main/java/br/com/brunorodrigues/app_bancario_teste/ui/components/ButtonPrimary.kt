package br.com.brunorodrigues.app_bancario_teste.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import br.com.brunorodrigues.app_bancario_teste.ui.theme.gray
import br.com.brunorodrigues.app_bancario_teste.ui.theme.green
import br.com.brunorodrigues.app_bancario_teste.ui.theme.white

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    isLoading: Boolean = false,
    enabled: Boolean = false,
    onClick: () -> Unit
    ) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = green,
            contentColor = white,
            disabledContainerColor = gray.copy(alpha = 0.4f)
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = white,
                strokeWidth = 2.dp,
                modifier = Modifier.size(20.dp)
            )
        } else Text(text = text, style = textStyle)
    }
}