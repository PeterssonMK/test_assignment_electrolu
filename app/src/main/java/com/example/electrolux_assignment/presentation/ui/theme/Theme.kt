package com.example.electrolux_assignment.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = darkColorScheme(
    surface = ThemeColors.DarkTheme.surface,
    primary = ThemeColors.DarkTheme.primary,
    onPrimary = ThemeColors.DarkTheme.primaryText,
    onPrimaryContainer = ThemeColors.DarkTheme.secondaryText,
    secondary = ThemeColors.DarkTheme.primaryIcon,
    tertiary = ThemeColors.DarkTheme.secondaryIcon,
    outline = ThemeColors.DarkTheme.divider,
)

private val LightColorScheme = lightColorScheme(
    surface = ThemeColors.LightTheme.surface,
    primary = ThemeColors.LightTheme.primary,
    onPrimary = ThemeColors.LightTheme.primaryText,
    onPrimaryContainer = ThemeColors.LightTheme.secondaryText,
    secondary = ThemeColors.LightTheme.primaryIcon,
    tertiary = ThemeColors.LightTheme.secondaryIcon,
    outline = ThemeColors.LightTheme.divider,
)

@Composable
fun ElectroluxAssignmentTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalSpacing provides Spacing()) {
        MaterialTheme(
            colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
            typography = Typography,
            content = content
        )
    }
}