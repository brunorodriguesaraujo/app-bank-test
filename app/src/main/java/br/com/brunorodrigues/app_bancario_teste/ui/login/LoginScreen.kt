package br.com.brunorodrigues.app_bancario_teste.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.brunorodrigues.app_bancario_teste.R
import br.com.brunorodrigues.app_bancario_teste.ui.components.ButtonPrimary
import br.com.brunorodrigues.app_bancario_teste.ui.components.TextFieldModule
import br.com.brunorodrigues.app_bancario_teste.ui.theme.gray
import br.com.brunorodrigues.app_bancario_teste.ui.theme.green
import br.com.brunorodrigues.app_bancario_teste.ui.theme.interFontFamily
import br.com.brunorodrigues.app_bancario_teste.ui.theme.white

@Composable
fun LoginScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.login),
                style = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
            Image(
                painterResource(id = R.drawable.image_logo),
                contentDescription = stringResource(R.string.image_logo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
            )
            TextFieldModule(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(8.dp)),
                placeholder = stringResource(R.string.email),
                textStyle = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.W400,
                    color = gray
                ),
            ) {

            }

            TextFieldModule(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(8.dp)),
                placeholder = stringResource(R.string.password),
                textStyle = TextStyle(
                    fontFamily = interFontFamily,
                    color = gray
                ),
            ) {

            }

            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = green),
                stringResource(R.string.login),
                textStyle = TextStyle(
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = white
                ),
            ) { }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}