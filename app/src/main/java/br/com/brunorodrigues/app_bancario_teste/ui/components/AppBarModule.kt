package br.com.brunorodrigues.app_bancario_teste.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import br.com.brunorodrigues.app_bancario_teste.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarModule(
    title: String,
    textStyle: TextStyle,
    onClickBackButton: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = textStyle
            )
        },
        navigationIcon = {
            IconButton(onClick = onClickBackButton) {
                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        }
    )
}