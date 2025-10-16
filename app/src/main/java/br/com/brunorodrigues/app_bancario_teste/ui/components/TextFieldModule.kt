package br.com.brunorodrigues.app_bancario_teste.ui.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun TextFieldModule(
    modifier: Modifier,
    placeholder: String,
    textStyle: TextStyle,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = "",
        onValueChange = onValueChange,
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
}