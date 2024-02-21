package com.example.bestiario_mhw.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bestiario_mhw.R

val KodeMono = FontFamily(
    Font(R.font.kodemono_regular, FontWeight.Normal),
    Font(R.font.kodemono_bold, FontWeight.Bold)
)

val ProtestRevolution = FontFamily(
    Font(R.font.protestrevolution_regular, FontWeight.Normal),
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = ProtestRevolution,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = KodeMono,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    displayMedium = TextStyle(
        fontFamily = KodeMono,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    displaySmall = TextStyle(
        fontFamily = KodeMono,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
)