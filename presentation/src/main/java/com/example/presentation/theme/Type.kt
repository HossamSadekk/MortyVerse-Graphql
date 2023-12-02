package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.theme.RalewayFonts

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        fontSize = SpDimensions.HeadlineLarge,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Medium,
        fontSize = SpDimensions.BodyLarge,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Normal,
        fontSize = SpDimensions.BodyMedium,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Normal,
        fontSize = SpDimensions.BodySmall,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = SpDimensions.TitleMedium,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = SpDimensions.TitleLarge,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        fontSize = SpDimensions.HeadlineMedium,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = SpDimensions.TitleSmall,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineSmall =TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        fontSize = SpDimensions.HeadlineSmall,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    )
)