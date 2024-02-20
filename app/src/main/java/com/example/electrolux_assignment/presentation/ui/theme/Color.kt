package com.example.electrolux_assignment.presentation.ui.theme

import androidx.compose.ui.graphics.Color

sealed class ThemeColors(
    val surface: Color,
    val primary: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val divider: Color,
    val primaryIcon: Color,
    val secondaryIcon: Color

) {
    object LightTheme : ThemeColors(
        surface = Color.LightGray,
        primary = Color(0xFFFFFFFF),
        primaryText = Color(0xFF323333),
        secondaryText = Color(0xFF707070),
        divider = Color(0xFFF5F5F5),
        primaryIcon = Color(0xFF707070),
        secondaryIcon = Color(0xFF4052EF)
    )

    object DarkTheme : ThemeColors(
        surface = Color.Black,
        primary = Color(0xFFF272727),
        primaryText = Color(0xFFFFFFFF),
        secondaryText = Color(0xFFA6A6A6),
        divider = Color(0xFF404040),
        primaryIcon = Color(0xFFA6A6A6),
        secondaryIcon = Color(0xFFAFB7FC)
    )
}
