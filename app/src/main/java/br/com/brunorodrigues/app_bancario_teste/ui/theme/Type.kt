package br.com.brunorodrigues.app_bancario_teste.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.brunorodrigues.app_bancario_teste.R

val interFontFamily = FontFamily(
    Font(resId = R.font.inter_bold, weight = FontWeight.Bold),
    Font(resId = R.font.inter_regular, weight = FontWeight.Medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    titleLarge = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    titleMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.W400,
        color = gray
    ),
    labelMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = steelBlue,
    ),
)