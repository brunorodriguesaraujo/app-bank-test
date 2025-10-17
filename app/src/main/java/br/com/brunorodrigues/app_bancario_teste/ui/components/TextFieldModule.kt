package br.com.brunorodrigues.app_bancario_teste.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import br.com.brunorodrigues.app_bancario_teste.ui.theme.black

@Composable
fun TextFieldModule(
    modifier: Modifier,
    value: String,
    placeholder: String,
    textStyle: TextStyle,
    isError: Boolean = false,
    errorMessage: String = "",
    onValueChange: (String) -> Unit,
) {
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle.copy(color = black),
            placeholder = {
                Text(text = placeholder, style = textStyle)
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = modifier
        )

        if (isError) {
            Text(
                text = errorMessage,
                style = textStyle,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}