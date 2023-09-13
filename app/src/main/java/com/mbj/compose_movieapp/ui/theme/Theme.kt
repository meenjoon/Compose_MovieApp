package com.mbj.compose_movieapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.mbj.compose_movieapp.ui.theme.color.ColorSet
import com.mbj.compose_movieapp.ui.theme.color.MyColors

private val LocalColors = staticCompositionLocalOf { ColorSet.Red.LightColors }

@Composable
fun Compose_MovieAppTheme(
    myColors: ColorSet = ColorSet.Red,
    typography: Typography = Typography,
    shapes: Shapes = Shapes,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        myColors.DarkColors
    } else {
        myColors.LightColors
    }

    /**
     * CompositionLocalProvider를 사용한 이유는 로컬 데이터를 공유하고 컴포저블 함수 간에 데이터를 전달하는 데 사용되며,
     * 특히 테마와 같이 앱의 모양과 느낌을 결정하는데 중요한 요소임
     */
    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colors = colors.material,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

val MaterialTheme.colorScheme: MyColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
