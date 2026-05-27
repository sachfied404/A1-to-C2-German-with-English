package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = AccentCyan,
    secondary = AccentGreen,
    tertiary = AccentCyan,
    background = BgPrimary,
    surface = BgCard,
    onPrimary = TextHigh,
    onSecondary = BgPrimary,
    onTertiary = TextHigh,
    onBackground = TextHigh,
    onSurface = TextHigh,
    surfaceVariant = ButtonBg,
    onSurfaceVariant = TextMed,
    outline = BorderColor,
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = true, // Force dark theme as per design
  dynamicColor: Boolean = false, // Disable dynamic colors to stick to design
  content: @Composable () -> Unit,
) {
  val colorScheme = DarkColorScheme

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
